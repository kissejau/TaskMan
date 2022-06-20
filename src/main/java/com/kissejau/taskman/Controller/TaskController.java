package com.kissejau.taskman.Controller;


import com.kissejau.taskman.Servicies.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import java.util.ArrayList;

@RestController
public class TaskController {

    @Autowired
    TaskService service;

    @GetMapping
    public String readTasks()
    {
        return service.readTasks();
    }

    @PostMapping("/add")
    public void addTask(@RequestBody String json) {
        service.addTask(json);
    };
}
