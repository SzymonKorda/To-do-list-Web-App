package com.example.demo.controllers;

import com.example.demo.model.Task;
import com.example.demo.services.TaskService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @PostMapping("/task")
    public void newTask(@RequestBody Task taskRequest) {
        taskService.newTask(taskRequest);
    }
}
