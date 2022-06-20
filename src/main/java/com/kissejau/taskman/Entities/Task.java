package com.kissejau.taskman.Entities;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Task {

    private UUID id;
    private String taskName;
    private String taskContext;
    private String date;

    public Task(){
        id = UUID.randomUUID();
        date =  LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + " " + LocalDate.now().toString();
    }

    public Task(String taskName, String taskContext)
    {
        this();
        this.taskName = taskName;
        this.taskContext = taskContext;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public void setTaskContext(String taskContext) {
        this.taskContext = taskContext;
    }

    public UUID getId() {
        return id;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getTaskContext() {
        return taskContext;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString()
    {
        return "------------------\nTASK: " + taskName + "\nCONTEXT: " + taskContext + "\nDATE: " + date + "\n------------------\n";
    }
}