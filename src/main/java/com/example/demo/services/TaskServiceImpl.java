package com.example.demo.services;

import com.example.demo.exceptions.TaskNotFoundException;
import com.example.demo.exceptions.UserNotFoundException;
import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.payload.request.TaskRequest;
import com.example.demo.payload.response.TaskResponse;
import com.example.demo.repositories.TaskRepository;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TaskServiceImpl implements TaskService{

    private TaskRepository taskRepository;
    private UserRepository userRepository;

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
//
//    @Override
//    public void updateTask(Long taskId, Task taskRequest) {
////        Task task = taskRepository.findById(taskId).get();
////        task.setName(taskRequest.getName());
////        task.setDescribe(taskRequest.getDescribe());
////        task.setDate(new Date());
////
////        taskRepository.save(task);
//    }
//
//    @Override
//    public void deleteTask(Long taskId) {
////        Task task = taskRepository.findById(taskId).get();
////        taskRepository.delete(task);
//    }
}
