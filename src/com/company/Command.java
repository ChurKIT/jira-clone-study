package com.company;

import com.company.Tasks.Task;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Map;
import java.util.Scanner;


public class Command {
    Scanner reader = new Scanner(System.in);

    public Command(String command) throws IOException {
        String[] splitCommand = command.split(" ");
        if (splitCommand [0].equals("/help")){
            System.out.println(new String(Files.readAllBytes(Paths.get("help.txt"))));
        }
        if (splitCommand [0].equals("/new")){
            new Task(splitCommand[1], splitCommand[2], splitCommand[3]);
        }
        if (splitCommand [0].equals("/print")){
            try {
                System.out.println(Task.getTask(Integer.parseInt(splitCommand[1])).toString());
            }
            catch (NullPointerException e){
                System.out.println("ERROR : Неккоректный ID задачи");
            }
        }
        if (splitCommand [0].equals("/remove")){
            RepositoryTasks.getSingleton().removeTask(Integer.parseInt(splitCommand[1]));
        }
        if (splitCommand [0].equals("/printAll")){
            for (Map.Entry<Integer, Task> entry : RepositoryTasks.getSingleton().tasks.entrySet()){
                System.out.println(entry.getValue().toString());
            }
        }
        if (splitCommand [0].equals("/setState")){
            if (splitCommand[2].equals("In") && splitCommand[3].equals("Progress")){
                Task.getTask(Integer.parseInt(splitCommand[1])).setTaskState(splitCommand[2] + " " + splitCommand[3]);
            }
            Task.getTask(Integer.parseInt(splitCommand[1])).setTaskState(splitCommand[2]);
        }
    }
}
