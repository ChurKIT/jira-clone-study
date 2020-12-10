package com.company.Users;

import com.company.RepositoryUsers;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class User {
    BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
    private String login;
    private String firstName;
    private String lastName;
    private String role;                            // не реализовано
    private static boolean isLogIn = false;

    public User(String login, String password){
        if (RepositoryUsers.getSingleton().singIn(login, password)){
            successLogin();
            this.login = login;
        } else {
            unSuccessLogin(login);
        }
    }

    public User(String login, String password, String firstName, String lastName, String role){
        RepositoryUsers.getSingleton().singUp(login, password);
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }

    private void successLogin(){
        System.out.println("Успешный вход");
        isLogIn = true;
    }

    private void unSuccessLogin(String login){
        if (RepositoryUsers.getSingleton().containsLogin(login)){
            System.out.println("Введен неверный пароль");
        } else {
            System.out.println("Такого логина не существует, пожалуйста зарегистрируйтесь");
        }
        isLogIn = false;
    }

    public static boolean isLogIn() {
        return isLogIn;
    }

    public String getLogin(){
        return login;
    }
}
