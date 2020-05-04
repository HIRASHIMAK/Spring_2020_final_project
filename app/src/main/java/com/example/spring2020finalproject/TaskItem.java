package com.example.spring2020finalproject;

public class TaskItem {
    private String taskSummary;
    private String dueDate;
    private String dueTime;

    public TaskItem(final String setTask, final String setDueDate, final String setDueTime) {
        taskSummary = setTask;
        dueDate = setDueDate;
        dueTime = setDueTime;
    }

    public String getTask() {
        return taskSummary;
    }

    public String getDueDate() {
        return dueDate;
    }

    public String getDueTime() {
        return dueTime;
    }
}
