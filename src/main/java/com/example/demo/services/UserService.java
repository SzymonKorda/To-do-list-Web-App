package com.example.demo.services;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.payload.request.LoginRequest;
import com.example.demo.payload.request.RegisterRequest;
import com.example.demo.payload.request.UserUpdateRequest;
import com.example.demo.payload.response.JwtResponse;
import com.example.demo.payload.response.TaskResponse;
import com.example.demo.payload.response.UserResponse;

import java.util.List;

public interface UserService {

    JwtResponse loginUser(LoginRequest loginRequest);
    void createUser(RegisterRequest registerRequest);
    UserResponse getUser(Long userId);
    void updateUser(Long userId, UserUpdateRequest userUpdateRequest);
    void deleteUser(Long userId);
    List<TaskResponse> getUserTasks(Long userId);
}
