package com.company;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;



public class DAO {
    //Реализация Singleton
    private static DAO singleton;

    private DAO() {
    }

    public static DAO getSingleton() {
        if (singleton == null) {
            singleton = new DAO();
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
