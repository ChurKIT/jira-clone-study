package com.company;

import com.company.Tasks.Task;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;



public class RepositoryTasks {
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
    protected Map<Integer, Task> tasks = new HashMap<Integer, Task>();
    //Счетчик ID задач
    private AtomicInteger atomTaskId = new AtomicInteger();



    public Integer setTask(Task task){
        tasks.put(atomTaskId.getAndIncrement(), task);
        return atomTaskId.get();
    }

    public Task returnTask(int taskId){
        return tasks.get(taskId);
    }

    public void removeTask(int taskId){
        tasks.remove(taskId);
    }

}
