package com.company;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
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
            new Task(newTaskParameters[0], newTaskParameters[1], newTaskParameters[2]);
        }
        if (command.equals("print")){
            try {
                System.out.println(Task.getTask(reader.nextInt()).toString());
            }
            catch (NullPointerException e){
                System.out.println("ERROR : Неккоректный ID задачи");
            }
        }
        if (command.equals("remove")){
            DAO.getSingleton().removeTask(reader.nextInt());
        }
        if (command.equals("printAll")){
            for (Map.Entry<Integer, Task> entry : DAO.getSingleton().tasks.entrySet()){
                System.out.println(entry.getValue().toString());
            }
        }
    }
}
