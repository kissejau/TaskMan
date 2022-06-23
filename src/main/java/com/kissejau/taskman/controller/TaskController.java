package com.kissejau.taskman.controller;

import com.kissejau.taskman.entity.Task;
import com.kissejau.taskman.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class TaskController {

    @Autowired
    TaskService service;

    @GetMapping
    public List<Task> readTasks()
    {
        return service.readTasks();
    }

    @DeleteMapping("/delete")
    public void deleteTask(@RequestBody String json)
    {
        service.deleteTask(json);
    }

    @GetMapping("/add")
    public String addTask()
    {
        return "add_task";
    }
    @PostMapping("/add")
    public void addTask(@RequestBody String json) {
        service.addTask(json);
    }

    @PutMapping("/update")
    public void updateTask(@RequestBody String json)
    {
        service.update(json);
    }
}
