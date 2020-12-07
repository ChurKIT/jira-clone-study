package com.company;

public enum TaskState {

    NEW ("New"),
    SOLVED ("Solved"),
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
