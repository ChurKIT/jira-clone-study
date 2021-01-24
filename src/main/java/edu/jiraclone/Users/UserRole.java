package edu.jiraclone.Users;

public class UserRole {

    private Roles role;

    public UserRole(String role){
        if (role.equalsIgnoreCase("developer") || role.equalsIgnoreCase("dev") || role.equalsIgnoreCase("develop") || role.equalsIgnoreCase("разработчик") || role.equalsIgnoreCase("программист")){
            this.role = Roles.DEVELOPER;
        } else if (role.equalsIgnoreCase("tester") || role.equalsIgnoreCase("test") || role.equalsIgnoreCase("тестер") || role.equalsIgnoreCase("тестировщик")){
            this.role = Roles.TESTER;
        } else if (role.equals("/make me admin")){
            this.role = Roles.ADMIN;
        } else {
            this.role = Roles.GUEST;
            System.out.println("Такой должности не существует, вы зарегистрированы как Гость");
        }
    }

    public UserRole(Roles role){
        this.role = role;
    }


    public Roles getRole() {
        return role;
    }

    public void setRole(Roles role) {
        this.role = role;
    }
}
