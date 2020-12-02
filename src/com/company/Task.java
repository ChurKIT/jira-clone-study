package com.company;

public class Task {
    private int taskId;
    private String taskName;
    private String taskAuthor;
    private String taskAssignee;
    private String taskState;

    public Task(int taskId, String taskName, String taskAuthor, String taskAssignee, String taskState) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.taskAuthor = taskAuthor;
        this.taskAssignee = taskAssignee;
        this.taskState = taskState;
        Repo.getSingleton().setTask(this.taskId, this);
    }

    public static Task getTask(int taskId){
        return Repo.getSingleton().getTask(taskId);
    }
/*
    public Task(String taskName, String taskAuthor, String taskAssignee) {
        this.taskName = taskName;
        this.taskAuthor = taskAuthor;
        this.taskAssignee = taskAssignee;
    }
*/
/*
    public int getTaskId() {
        return taskId;
    }

    public void setTaskId(int taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskAuthor() {
        return taskAuthor;
    }

    public void setTaskAuthor(String taskAuthor) {
        this.taskAuthor = taskAuthor;
    }

    public String getTaskAssignee() {
        return taskAssignee;
    }

    public void setTaskAssignee(String taskAssignee) {
        this.taskAssignee = taskAssignee;
    }

    public String getTaskState() {
        return taskState;
    }

    public void setTaskState(String taskState) {
        this.taskState = taskState;
    }
*/
    @Override
    public String toString() {
        return taskId + ":" + taskName + ":" + taskAuthor + ":" + taskAssignee + ":" + taskState;
    }
}
