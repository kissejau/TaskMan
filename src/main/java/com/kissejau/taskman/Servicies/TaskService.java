package com.kissejau.taskman.Servicies;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kissejau.taskman.Entities.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Map;

@Service
public class TaskService {

    ArrayList<Task> tasks = new ArrayList<Task>();

    public String readTasks()
    {
        String out = "";
        for (Task task : tasks)
        {
            out += task.toString();
        }
        return out;
    }

    public boolean addTask(String json)
    {
        Map<String, String> map = null;
        try {
            map = new ObjectMapper().readValue(json, Map.class);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }

        if (map == null
                || map.isEmpty()
                || !map.containsKey("name")
                || !map.containsKey("context")
        )
            return false;
        else
        {
            tasks.add(new Task(map.get("name"), map.get("context")));
            return true;
        }
    }
}
