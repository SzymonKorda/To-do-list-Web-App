package com.example.demo.controllers;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.payload.request.LoginRequest;
import com.example.demo.payload.request.RegisterRequest;
import com.example.demo.payload.response.ApiResponse;
import com.example.demo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        userService.createUser(registerRequest);
        return ResponseEntity.ok(new ApiResponse("User registered successfully!"));
    }

    @PostMapping("/user/login")
    public ResponseEntity authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.loginUser(loginRequest));
    }

    @GetMapping("/user/{userId}")
    public User getUser(@PathVariable long userId) {
        return userService.getUser(userId);
    }

    @PostMapping("/user/{userId}")
    public void updateUser(@PathVariable long userId, @RequestBody User user) {
        userService.updateUser(userId, user);
    }

    @DeleteMapping("/user/{userId}")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/user/{userId}/tasks")
    public List<Task> getAllTasks(@PathVariable Long userId) {
        return userService.getUserTasks(userId);
    }
}
