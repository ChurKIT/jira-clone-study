package edu.jiraclone;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.exc.MismatchedInputException;
import edu.jiraclone.Tasks.Task;


import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;



public class RepositoryTasks implements Serializable {
    //Реализация Singleton
    private static RepositoryTasks singleton;

    private RepositoryTasks() {
    }

    public static RepositoryTasks getSingleton() {
        if (singleton == null) {
            singleton = new RepositoryTasks();
        }
        return singleton;
    }

    //Множество всех задач
    private ArrayList<Task> tasks = new ArrayList<Task>();


    public void addTask(Task task){
        tasks.add(task);
    }

    public Task returnTask(int taskId){
        for (Task task : tasks) {
            if (task.getTaskId() == taskId) {
                return tasks.get(taskId);
            } else {
                System.out.println("Задачи с таким ID не существует");
            }
        }
        return null;
    }

    public void removeTask(int taskId){
        for (Task task : tasks) {
            if (task.getTaskId() == taskId) {
                tasks.remove(taskId);
            } else {
                System.out.println("Задачи с таким ID не существует");
            }
        }
    }

    public ArrayList<Task> getTasks() {
        return tasks;
    }

    public void readFromJson(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.tasks = mapper.readValue(new File("src/main/resources/tasks.json"), new TypeReference<ArrayList<Task>>() {
                @Override
                public Type getType() {
                    return super.getType();
                }
            });
        } catch (MismatchedInputException e){
            System.out.println("ERROR: Json файл пустой");
        } catch (IOException e) {
            System.out.println("ERROR: Ошибка при чтении из Json");
            e.printStackTrace();
        }
    }

    public void writeToJson(){
        ObjectMapper mapper = new ObjectMapper();
        try {
            mapper.writeValue(new File("src/main/resources/tasks.json"), this.tasks);
        } catch (IOException e) {
            System.out.println("ERROR: Ошибка при записи в Json");
            e.printStackTrace();
        }
    }
}
