package com.example.demo.services;

import com.example.demo.model.Task;
import com.example.demo.model.User;

public interface TaskService {

    void newTask(Task taskRequest, Long userId);
    Task getTask(Long taskId);
    void updateTask(Long taskId, Task taskRequest);
    void deleteTask(Long taskId);
}
