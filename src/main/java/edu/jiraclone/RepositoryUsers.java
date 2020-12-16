package edu.jiraclone;

import edu.jiraclone.Users.User;

import java.util.HashMap;
import java.util.Map;

public class RepositoryUsers {
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
    protected Map<String, String> logPass = new HashMap<String, String>();
    protected Map<String, User> logUser = new HashMap<String, User>();

    public void singUp(String login, String password, User user){
        logPass.put(login, password);
        logUser.put(login, user);

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





}
