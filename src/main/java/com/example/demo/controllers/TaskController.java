package com.example.demo.controllers;

import com.example.demo.payload.request.TaskRequest;
import com.example.demo.payload.request.TaskUpdateRequest;
import com.example.demo.payload.response.ApiResponse;
import com.example.demo.payload.response.TaskResponse;
import com.example.demo.services.TaskService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/task/{taskId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public TaskResponse getTask(@PathVariable Long taskId) {
        return taskService.getTask(taskId);
    }

    @PostMapping("/user/{userId}/task")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> createTask(@PathVariable Long userId, @RequestBody TaskRequest taskRequest) {
        taskService.createTask(taskRequest, userId);
        return ResponseEntity.ok(new ApiResponse("Task created successfully!"));
    }

    @PostMapping("/task/{taskId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> updateTask(@PathVariable Long taskId, @RequestBody TaskUpdateRequest taskUpdateRequest) {
        taskService.updateTask(taskId, taskUpdateRequest);
        return ResponseEntity.ok(new ApiResponse("Task updated successfully!"));
    }

    @DeleteMapping("/task/{taskId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteTask(@PathVariable Long taskId) {
        taskService.deleteTask(taskId);
        return ResponseEntity.ok(new ApiResponse("Task deleted successfully!"));
    }
}
