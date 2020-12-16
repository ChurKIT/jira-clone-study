package edu.jiraclone.Tasks;

public enum TaskState {

    NEW ("New"),
    INPROGRESS ("In Progress"),
    RESOLVED ("Resolved"),
    CLOSED ("Closed"),
    REOPENED ("Reopened");


    private String description;

    TaskState(String description) {
        this.description = description;
    }


    @Override
    public String toString() {
        return description;
    }
}
