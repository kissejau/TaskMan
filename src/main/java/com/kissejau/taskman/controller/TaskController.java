package com.kissejau.taskman.controller;


import com.kissejau.taskman.entity.Task;
import com.kissejau.taskman.service.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;

@RestController
public class TaskController {

    @Autowired
    TaskService service;

    @GetMapping
    public String readTasks(HttpServletRequest request)
    {
        return service.readTasks();
    }

    @PostMapping("/add")
    public void addTask(@RequestBody String json) {
        service.addTask(json);
    };
}
