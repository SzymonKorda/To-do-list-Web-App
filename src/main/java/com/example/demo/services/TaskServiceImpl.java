package com.example.demo.services;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.repositories.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class TaskServiceImpl implements TaskService{

    private TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public void newTask(Task taskRequest) {
        Task task = new Task();
        task.setName(taskRequest.getName());
        task.setDescribe(taskRequest.getDescribe());
        task.setDate(new Date());
//        task.setUser(user);
        taskRepository.save(task);
    }
}
