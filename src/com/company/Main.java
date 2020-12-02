package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите команду:");
        String command;
        do{
            command = reader.readLine();
            new Command(command);
        } while (!command.equals("quit"));
        /*
        new Task(1, "name1", "author1", "assignee1", "new");
        new Task(2, "name2", "author2", "assignee2", "new");
        new Task(3, "name3", "author3", "assignee3", "new");
        System.out.println(Task.getTask(1).toString());

        new Task(1, "name4", "author4", "assignee4", "replaced");
        System.out.println(Task.getTask(1).toString());
        */
    }
}
