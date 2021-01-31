package edu.jiraclone;

import edu.jiraclone.Users.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{

    public static void main(String[] args) throws IOException {
        RepositoryUsers.getInstance().readFromJson();
        RepositoryTasks.getSingleton().readFromJson();
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String command;
        while (!User.isLogIn()) {
            System.out.println("Пожалуйста авторизируйтесь или зарегистрируйтесь с помощью команд /singin или /singup");
            command = reader.readLine();
            if (command.equals("/quit")){
                System.exit(0);
            }
            if (command.equals("/singin") || command.equals("/singup")){
                new Command(command);
            }
        }
        do{
            command = reader.readLine();
            new Command(command);
        } while (!command.equals("/quit"));
        RepositoryTasks.getSingleton().writeToJson();
        RepositoryUsers.getInstance().writeToJson();
    }
}
