package edu.jiraclone.Users;

import edu.jiraclone.RepositoryUsers;


public class User {

    private String login;
    private String firstName;
    private String lastName;
    private UserRole role;                            // не реализовано
    private static boolean isLogIn = false;
    //конструктор для добавления нового пользователя в RepositoryUsers
    public User(String login, String password, String firstName, String lastName, String role){
        this.login = login;
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = new UserRole(role);
        RepositoryUsers.getInstance().singUp(login, password, this);
    }

    public User() {

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
        isLogIn = true;
    }

    private static void unSuccessLogin(String login){
        if (RepositoryUsers.getInstance().containsLogin(login)){
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

    public Roles getRole() {
        return role.getRole();
    }

    public void logOut(){
        isLogIn = false;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }
}
