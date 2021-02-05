package com.example.demo.services;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.payload.request.TaskRequest;
import com.example.demo.payload.request.TaskUpdateRequest;
import com.example.demo.payload.response.TaskResponse;

public interface TaskService {
    void createTask(TaskRequest taskRequest, Long userId);
    TaskResponse getTask(Long taskId);
    void updateTask(Long taskId, TaskUpdateRequest taskUpdateRequest);
    void deleteTask(Long taskId);
}
