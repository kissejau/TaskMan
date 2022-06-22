package com.kissejau.taskman.entity;


import java.time.LocalDate;
import java.time.LocalTime;
import java.util.UUID;

public class Task {

    private String id;
    private String name;
    private String context;
    private String date;


    public Task(){
        id = UUID.randomUUID().toString();
        date =  LocalTime.now().getHour() + ":" + LocalTime.now().getMinute() + " " + LocalDate.now().toString();
    }

    public Task(String name, String context)
    {
        this();
        this.name = name;
        this.context = context;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public void setId(String id) { this.id = id; }

    public void setDate(String date) { this.date = date; }
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getContext() {
        return context;
    }

    public String getDate() {
        return date;
    }

    @Override
    public String toString()
    {
        return "------------------\nTASK: " + name + "\nCONTEXT: " + context + "\nDATE: " + date + "\n------------------\n";
    }

}