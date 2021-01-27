package edu.jiraclone.Tasks;

import edu.jiraclone.RepositoryTasks;

import java.util.concurrent.atomic.AtomicInteger;

public class Task {
    private final AtomicInteger counter = new AtomicInteger(RepositoryTasks.getSingleton().getTasks().size());
    private int taskId;
    private String taskName;
    private String taskAuthor;
    private String taskAssignee;
    private String taskState;


    public Task(String taskName, String taskAuthor, String taskAssignee) {
        this.taskName = taskName;
        this.taskAuthor = taskAuthor;
        this.taskAssignee = taskAssignee;
        this.taskState = "New";
        this.taskId = counter.getAndIncrement();
        RepositoryTasks.getSingleton().addTask(this);
        System.out.println("Задача с параметрами " + this.toString() + " успешно создана");
    }

    public Task(){

    }


    public void setTaskAssignee(String newAssignee){
        this.taskAssignee = newAssignee;
    }

    public void setTaskState(String newTaskState) {
        if (newTaskState.equals(TaskState.INPROGRESS.toString())) {
            this.taskState = TaskState.INPROGRESS.toString();
        }
        if (newTaskState.equals(TaskState.CLOSED.toString())) {
            this.taskState = TaskState.CLOSED.toString();
        }
        if (newTaskState.equals(TaskState.RESOLVED.toString())) {
            this.taskState = TaskState.RESOLVED.toString();
        }
        if (newTaskState.equals(TaskState.REOPENED.toString())) {
            this.taskState = TaskState.REOPENED.toString();
        }
        if (newTaskState.equals(TaskState.NEW.toString())) {
            this.taskState = TaskState.NEW.toString();
        }
        if (newTaskState.isEmpty()) {
            this.taskState = "ERROR";
        }
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskAuthor(String taskAuthor) {
        this.taskAuthor = taskAuthor;
    }

    public int getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskAuthor() {
        return taskAuthor;
    }

    public String getTaskAssignee() {
        return taskAssignee;
    }

    public String getTaskState() {
        return taskState;
    }


    @Override
    public String toString() {
        return taskId + ":" + taskName + ":" + taskAuthor + ":" + taskAssignee + ":" + taskState;
    }
}
