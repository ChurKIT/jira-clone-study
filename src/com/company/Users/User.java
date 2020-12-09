package com.company.Users;

import com.company.RepositoryUsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class User {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String firstName;
    private String lastName;
    private Role role;

    public User(String login, String password){
        if (RepositoryUsers.getSingleton().singIn(login, password)){
            successLogin();
        } else {
            unSuccessLogin(login);
        }
    }

    private void successLogin(){
        System.out.println("Успешный вход");
    }

    private void unSuccessLogin(String login){
        if (RepositoryUsers.getSingleton().containsLogin(login)){
            System.out.println("Введен неверный пароль");
        } else {
            System.out.println("Такого логина не существует, пожалуйста зарегистрируйтесь");
        }
    }
}
