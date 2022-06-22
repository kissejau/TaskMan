package com.kissejau.taskman.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kissejau.taskman.dao.TaskmanJdbcDAO;
import com.kissejau.taskman.entity.Task;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class TaskService {

    TaskmanJdbcDAO db;

    public TaskService()
    {
        db = new TaskmanJdbcDAO();
    }

    public Map<String, String> jsonToMap(String json)
    {
        Map<String, String> map = null;
        try {
            map = new ObjectMapper().readValue(json, Map.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return map;
    }
//    public void syncTasks(Cookie[] cookies) // sync tasks with cookies (if tasks - empty)
//    {
//        Map<String, String> map;
//        if (tasks.isEmpty())
//            for (Cookie c : cookies)
//            {
//                tasks.add(new Task(c.getName(), c.getValue()));
//            }
//    }

    public String readTasks()
    {
        String out = "";
        for (Task task : db.list())
        {
            out += task.toString();
        }
        return out;
    }

    public boolean deleteTask(String json)
    {
        Map<String, String> map = jsonToMap(json);
        if (map == null
        || map.isEmpty()
        || !map.containsKey("id"))
            return false;
        else{
            db.delete(map.get("id"));
            return true;
        }
    }

    public boolean addTask(String json)
    {
        Map<String, String> map = jsonToMap(json);

        if (map == null
                || map.isEmpty()
                || !map.containsKey("name")
                || !map.containsKey("context")
        )
            return false;
        else
        {
            db.create(new Task(map.get("name"), map.get("context")));
            return true;
        }

    }

    public boolean update(String json)
    {
        Map<String, String> map = jsonToMap(json);
        Task task;

        if (map == null
        || map.isEmpty()
        || !map.containsKey("id")
        || !(map.containsKey("name") || map.containsKey("context")))
            return false;
        else
        {
            task = db.get(map.get("id"));
            if (map.containsKey("name"))
                task.setName(map.get("name"));
            if (map.containsKey("context"))
                task.setContext(map.get("context"));
            db.update(task, map.get("id"));
            return true;
        }
    }
}
