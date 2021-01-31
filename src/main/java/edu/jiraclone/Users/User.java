package edu.jiraclone.Users;

import edu.jiraclone.RepositoryUsers;

import java.util.Arrays;


public class User {

    private String login;
    private String password;
    private String firstName;
    private String lastName;
    private UserRole role;                            // не реализовано
    private static boolean logIn = false;

    public static void setLogIn(boolean logIn) {
        User.logIn = logIn;
    }

    //конструктор для добавления нового пользователя в RepositoryUsers
    public User(String login, String password, String firstName, String lastName, String role){
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = new UserRole(role);
        this.password = password;
        RepositoryUsers.getInstance().singUp(login, password, this);
    }
    //конструктор для добавления нового пользователя в RepositoryUsers
    public User(String login, String password, String firstName, String lastName, Roles role){
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = new UserRole(role);
        this.password = password;
        RepositoryUsers.getInstance().singUp(login, password, this);
    }

    public User() {
        RepositoryUsers.getInstance().singUp(login, password, this);
    }


    public static User singIn(String login, String password){
        if (RepositoryUsers.getInstance().singIn(login, password)){
            successLogin();
        } else {
            unSuccessLogin(login);
        }
        return RepositoryUsers.getInstance().getUser(login);
    }

    private static void successLogin(){
        System.out.println("Успешный вход");
        logIn = true;
    }

    private static void unSuccessLogin(String login){
        if (RepositoryUsers.getInstance().containsLogin(login)){
            System.out.println("Введен неверный пароль");
        } else {
            System.out.println("Такого логина не существует, пожалуйста зарегистрируйтесь");
        }
        logIn = false;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public static boolean isLogIn() {
        return logIn;
    }

    public String getLogin(){
        return login;
    }

    public Roles getRole() {
        return role.getRole();
    }

    public void logOut(){
        logIn = false;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
