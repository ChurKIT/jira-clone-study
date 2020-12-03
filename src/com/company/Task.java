package com.company;

public class Task {
    private int taskId;
    private String taskName;
    private String taskAuthor;
    private String taskAssignee;
    private String taskState;

    public static Task getTask(int taskId) {
        return DAO.getSingleton().returnTask(taskId - 1);
    }

    public Task(String taskName, String taskAuthor, String taskAssignee) {
        this.taskName = taskName;
        this.taskAuthor = taskAuthor;
        this.taskAssignee = taskAssignee;
        this.taskId = DAO.getSingleton().setTask(this);
        System.out.println("Задача с параметрами " + this.toString() + " успешно создана");
    }


    @Override
    public String toString() {
        return taskId + ":" + taskName + ":" + taskAuthor + ":" + taskAssignee + ":" + taskState;
    }
}
