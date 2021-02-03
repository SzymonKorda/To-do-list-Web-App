package com.example.demo.services;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.payload.request.LoginRequest;
import com.example.demo.payload.request.RegisterRequest;
import com.example.demo.payload.response.JwtResponse;

import java.util.List;

public interface UserService {

    JwtResponse loginUser(LoginRequest loginRequest);
    void createUser(RegisterRequest registerRequest);
    User getUser(Long userId);
    void updateUser(Long userId, User userRequest);
    void deleteUser(Long userId);
    List<Task> getUserTasks(Long userID);
}
