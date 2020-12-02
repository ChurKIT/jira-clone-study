package com.company;

public class Main {

    public static void main(String[] args) {
        //Создание тестовых задач
        new Task(1, "name1", "author1", "assignee1", "new");
        new Task(2, "name2", "author2", "assignee2", "new");
        new Task(3, "name3", "author3", "assignee3", "new");
        System.out.println(Task.getTask(1).toString());

        new Task(1, "name4", "author4", "assignee4", "replaced");
        System.out.println(Task.getTask(1).toString());
    }
}
