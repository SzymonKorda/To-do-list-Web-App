package com.example.demo.controllers;

import com.example.demo.model.Task;
import com.example.demo.services.TaskService;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    private TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task/{taskId}")
    public Task getTask(@PathVariable Long taskId) {
        return taskService.getTask(taskId);
    }

    @PostMapping("/user/{userId}/task")
    public void newTask(@PathVariable Long userId, @RequestBody Task taskRequest) {
        taskService.newTask(taskRequest, userId);
    }

    @PostMapping("/task/{taskId}")
    public void updateTask(@PathVariable Long taskId, @RequestBody Task taskRequest) {
        taskService.updateTask(taskId, taskRequest);
    }

    @DeleteMapping("/task/{taskId}")
    public void deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
    }
}
