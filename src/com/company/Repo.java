package com.company;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Repo {
    //Реализация Singleton
    private static Repo singleton;

    private Repo() {
    }

    public static Repo getSingleton() {
        if (singleton == null) {
            singleton = new Repo();
        }
        return singleton;
    }

    //Множество всех задач
    private Map<Integer, Task> tasks = new HashMap<>();


    public void setTask(int taskId, Task task){
        tasks.put(taskId, task);
    }

    public Task getTask(int taskId){
        return tasks.get(taskId);
    }

    public void removeTask(int taskId){
        tasks.remove(taskId);
    }
}
