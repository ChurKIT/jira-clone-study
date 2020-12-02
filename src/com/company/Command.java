package com.company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Command {
    Scanner reader = new Scanner(System.in);

    public Command(String command) throws IOException {
        if (command.equals("help")){
            System.out.println(new String(Files.readAllBytes(Paths.get("help.txt"))));
        }
        if (command.equals("new")){
            String newTask = reader.nextLine();
            String[] newTaskParameters;
            newTaskParameters = newTask.split(":");
            new Task(Integer.parseInt(newTaskParameters[0]), newTaskParameters[1], newTaskParameters[2], newTaskParameters[3], newTaskParameters[4]);
        }
        if (command.equals("print")){
            System.out.println(Task.getTask(reader.nextInt()).toString());
        }
        if (command.equals("remove")){
            Repo.getSingleton().removeTask(reader.nextInt());
        }
    }
}
