package edu.jiraclone;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import edu.jiraclone.Tasks.Task;
import edu.jiraclone.Users.User;

import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.*;

public class RepositoryUsers implements Serializable {
    //Реализация Singleton
    private static RepositoryUsers singleton;

    private RepositoryUsers() {
    }

    public static RepositoryUsers getInstance() {
        if (singleton == null) {
            singleton = new RepositoryUsers();
        }
        return singleton;
    }

    //Множество всех пользователей
    protected transient Map<String, String> logPass = new HashMap<String, String>();
    protected transient Map<String, User> logUser = new HashMap<String, User>();
    protected List<User> users = new ArrayList<User>();

    public void singUp(String login, String password, User user){
        logPass.put(login, password);
        logUser.put(login, user);
        users.add(user);
    }

    public boolean singIn (String login, String password){
        if (logPass.containsKey(login)){
            if (logPass.get(login).equals(password)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public User getUser(String login){
        return logUser.get(login);
    }

    public boolean containsLogin (String login){
        return logPass.containsKey(login);
    }

    public void readFromJson(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.users = mapper.readValue(new File("src/main/resources/users.json"), new TypeReference<ArrayList<User>>() {
                @Override
                public Type getType() {
                    return super.getType();
                }
            });
            for (User user : users){
                logPass.put(user.getLogin(), user.getPassword());
                logUser.put(user.getLogin(),user);
            }
        } catch (MismatchedInputException e){
            System.out.println("ERROR: users.json пустой");
        } catch (IOException e) {
            System.out.println("ERROR: Ошибка при чтении из users.json");
            e.printStackTrace();
        }
    }

    public void writeToJson(){
        ObjectMapper mapper = new ObjectMapper();
        try{
            mapper.writeValue(new File("src/main/resources/users.json"), this.users);
        } catch (IOException e){
            System.out.println("ERROR: Ошибка при записи в users.json");
            e.printStackTrace();
        }
    }

    public List<User> getUsers() {
        return users;
    }

    public void setUsers(List<User> users) {
        this.users = users;
    }
}
