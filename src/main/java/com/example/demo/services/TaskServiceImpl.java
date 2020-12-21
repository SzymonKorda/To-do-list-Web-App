package com.example.demo.services;

import com.example.demo.model.Task;
import com.example.demo.model.User;
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
    public void newTask(Task taskRequest, Long userId) {
        userId = 1L;

        Task task = new Task();
        task.setName(taskRequest.getName());
        task.setDescribe(taskRequest.getDescribe());
        task.setDate(new Date());

        User user = userRepository.findById(userId).get();
        task.setUser(user);

        user.getTasks().add(task);
        userRepository.save(user);
    }

    @Override
    public Task getTask(Long taskId) {
        return taskRepository.findById(taskId).get();
    }

    @Override
    public void updateTask(Long taskId, Task taskRequest) {
        Task task = taskRepository.findById(taskId).get();
        task.setName(taskRequest.getName());
        task.setDescribe(taskRequest.getDescribe());
        task.setDate(new Date());

        taskRepository.save(task);
    }

    @Override
    public void deleteTask(Long taskId) {
        Task task = taskRepository.findById(taskId).get();
        taskRepository.delete(task);
    }
}
