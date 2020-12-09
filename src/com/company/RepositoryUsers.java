package com.company;

import com.company.Tasks.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public class RepositoryUsers {
    //Реализация Singleton
    private static RepositoryUsers singleton;

    private RepositoryUsers() {
    }

    public static RepositoryUsers getSingleton() {
        if (singleton == null) {
            singleton = new RepositoryUsers();
        }
        return singleton;
    }

    //Множество всех пользователей
    protected Map<String, String> users = new HashMap<String, String>();

    public void singUp(String login, String password){
        users.put(login, password);
    }

    public boolean singIn (String login, String password){
        if (users.containsKey(login)){
            if (users.get(login).equals(password)){
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }

    public boolean containsLogin (String login){
        return users.containsKey(login);
    }




}
