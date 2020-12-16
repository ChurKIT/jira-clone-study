package edu.jiraclone.Tasks;

import edu.jiraclone.RepositoryTasks;

public class Task {
    private int taskId;
    private String taskName;
    private String taskAuthor;
    private String taskAssignee;
    private String taskState;

    public static Task getTask(int taskId) {
        return RepositoryTasks.getSingleton().returnTask(taskId - 1);
    }

    public Task(String taskName, String taskAuthor, String taskAssignee) {
        this.taskName = taskName;
        this.taskAuthor = taskAuthor;
        this.taskAssignee = taskAssignee;
        this.taskState = TaskState.NEW.toString();
        this.taskId = RepositoryTasks.getSingleton().setTask(this);
        System.out.println("Задача с параметрами " + this.toString() + " успешно создана");
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
    }


    @Override
    public String toString() {
        return taskId + ":" + taskName + ":" + taskAuthor + ":" + taskAssignee + ":" + taskState;
    }
}
