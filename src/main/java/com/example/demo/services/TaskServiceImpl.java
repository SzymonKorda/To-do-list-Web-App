package com.example.demo.services;

import com.example.demo.exceptions.TaskNotFoundException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.payload.request.TaskRequest;
import com.example.demo.payload.request.TaskUpdateRequest;
import com.example.demo.payload.response.TaskResponse;
import com.example.demo.repositories.TaskRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class TaskServiceImpl implements TaskService{

    private final TaskRepository taskRepository;
    private final UserRepository userRepository;

    public TaskServiceImpl(TaskRepository taskRepository, UserRepository userRepository) {
        this.taskRepository = taskRepository;
        this.userRepository = userRepository;
    }

    @Override
    public void createTask(TaskRequest taskRequest, Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User not found!"));

        Task task = new Task(
                taskRequest.getName(),
                taskRequest.getDescribe(),
                null,
                true,
                user
        );
        user.getTasks().add(task);
        userRepository.save(user);
    }

    @Override
    public TaskResponse getTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task not found!"));

        return new TaskResponse(
                task.getName(),
                task.getDescribe(),
                task.getCreateDate(),
                task.getAchievedDate(),
                task.isStatus()
        );
    }

    @Override
    public void updateTask(Long taskId, TaskUpdateRequest taskUpdateRequest) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task not found!"));

        if (taskUpdateRequest.getName() != null) {
            task.setName(taskUpdateRequest.getName());
        }
        if (taskUpdateRequest.getDescribe() != null) {
            task.setDescribe(taskUpdateRequest.getDescribe());
        }

        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId)
                .orElseThrow(() -> new TaskNotFoundException("Task not found!"));
        taskRepository.delete(task);
    }
}
