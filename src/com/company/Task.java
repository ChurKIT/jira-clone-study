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
        this.taskState = "New";
        this.taskId = DAO.getSingleton().setTask(this);
        System.out.println("Задача с параметрами " + this.toString() + " успешно создана");
    }

    public void setTaskAssignee(String newAssignee){
        this.taskAssignee = newAssignee;
    }

    public void setTaskState(String newTaskState){
        this.taskState = newTaskState;
    }


    @Override
    public String toString() {
        return taskId + ":" + taskName + ":" + taskAuthor + ":" + taskAssignee + ":" + taskState;
    }
}
