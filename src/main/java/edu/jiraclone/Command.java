package edu.jiraclone;

import edu.jiraclone.Tasks.Task;
import edu.jiraclone.Users.Roles;
import edu.jiraclone.Users.User;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;


public class Command {
    static User thisUser;
    Scanner reader = new Scanner(System.in);

    public Command(String command) throws IOException {
        String[] splitCommand = command.split(" ");

        if (splitCommand [0].equals("/singin")){
            try {
                System.out.println("Введите логин и пароль:");
                thisUser = User.singIn(reader.next(), reader.next());
            } catch (NullPointerException e){
                System.out.println("Такого логина не существует");
            }
            if (User.isLogIn()){
                System.out.println("Добро пожаловать, " + thisUser.getFirstName() + " " + thisUser.getLastName());
            }
        }
        //Регистрация нового пользователя
        if (splitCommand [0].equals("/singup")){
            System.out.println("Введите имя:");
            String firstName = reader.nextLine();
            System.out.println("Введите фамилию:");
            String lastName = reader.nextLine();
            System.out.println("Введите логин:");
            String login = reader.nextLine();
            while (RepositoryUsers.getInstance().containsLogin(login)){
                System.out.println("Такой логин уже существует, попробуйте другой:");
                login = reader.nextLine();
            }
            System.out.println("Введите пароль:");
            String password = reader.nextLine();
            System.out.println("Введите должность:");
            String role = reader.nextLine();
            new User(login, password, firstName, lastName, role);
            System.out.println("Регистрация прошла успешно");
        }

        if (splitCommand [0].equals("/help")){
            System.out.println(new String(Files.readAllBytes(Paths.get("src/main/resources/help.txt"))));
        }

        if (splitCommand [0].equals("/new")){
            if (thisUser.getRole() == Roles.ADMIN || thisUser.getRole() == Roles.DEVELOPER || thisUser.getRole() == Roles.TESTER) {
                System.out.println("Введите логин дальнейшего держателя задачи:");
                String assignee = reader.nextLine();
                String taskName = "";
                for (int i = 1; i < splitCommand.length; i++){
                    taskName = taskName + " " + splitCommand[i];
                }
                new Task(taskName, thisUser.getLogin(), assignee);
            } else {
                System.out.println("ERROR : У Вас недостаточно прав");
            }
        }

        if (splitCommand [0].equals("/print")){
            if (thisUser.getRole() == Roles.ADMIN || thisUser.getRole() == Roles.DEVELOPER || thisUser.getRole() == Roles.TESTER) {
                try {
                    System.out.println(RepositoryTasks.getSingleton().returnTask(Integer.parseInt(splitCommand[1])).toString());
                } catch (NullPointerException e) {
                    System.out.println("ERROR : Неккоректный ID задачи");
                }
            } else {
                System.out.println("ERROR : У Вас недостаточно прав");
            }
        }

        if (splitCommand [0].equals("/remove")){
            if (thisUser.getRole() == Roles.ADMIN || thisUser.getRole() == Roles.DEVELOPER || thisUser.getRole() == Roles.TESTER) {
                RepositoryTasks.getSingleton().removeTask(Integer.parseInt(splitCommand[1]));
            } else {
                System.out.println("ERROR : У Вас недостаточно прав");
            }
        }

        if (splitCommand [0].equals("/printAll")){
            if (thisUser.getRole() == Roles.ADMIN) {
                for (Task task : RepositoryTasks.getSingleton().getTasks()) {
                    System.out.println(task.toString());
                }
            } else {
                System.out.println("ERROR : У Вас недостаточно прав");
            }
        }
        /*
        if (splitCommand [0].equals("/setState")) {
            if (thisUser.getRole() == Roles.ADMIN || thisUser.getRole() == Roles.DEVELOPER || thisUser.getRole() == Roles.TESTER) {
                if (splitCommand[2].equals("In") && splitCommand[3].equals("Progress")) {
                    RepositoryTasks.getSingleton().returnTask(Integer.parseInt(splitCommand[1])).setTaskState(splitCommand[2] + " " + splitCommand[3]);
                }
                RepositoryTasks.getSingleton().returnTask(Integer.parseInt(splitCommand[1])).setTaskState(splitCommand[2]);
            } else {
                System.out.println("ERROR : У Вас недостаточно прав");
            }
        }
        */
        if (splitCommand [0].equals("/userinfo")) {
            if (User.isLogIn()) {
                System.out.println("Логин: " + thisUser.getLogin());
                System.out.println("Статус: " + thisUser.getRole().toString());
            } else {
                System.out.println("Пожалуйста войдите в систему");
            }
        }

        if (splitCommand [0].equals("/logout")){
            thisUser.logOut();
            System.out.println("Пожалуйста авторизируйтесь или зарегистрируйтесь с помощью команд /singin или /singup");
        }
    }
}
