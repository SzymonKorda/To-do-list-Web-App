package com.example.demo.controllers;

import com.example.demo.payload.request.LoginRequest;
import com.example.demo.payload.request.RegisterRequest;
import com.example.demo.payload.request.UserUpdateRequest;
import com.example.demo.payload.response.ApiResponse;
import com.example.demo.payload.response.TaskResponse;
import com.example.demo.payload.response.UserResponse;
import com.example.demo.services.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/auth/register")
    public ResponseEntity<?> registerUser(@Valid @RequestBody RegisterRequest registerRequest) {
        userService.createUser(registerRequest);
        return ResponseEntity.ok(new ApiResponse("User registered successfully!"));
    }

    @PostMapping("/auth/login")
    public ResponseEntity<?> authenticateUser(@Valid @RequestBody LoginRequest loginRequest) {
        return ResponseEntity.ok(userService.loginUser(loginRequest));
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public UserResponse getUser(@PathVariable Long userId) {
        return userService.getUser(userId);
    }

    @PostMapping("/user/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> updateUser(@PathVariable Long userId, @RequestBody UserUpdateRequest userUpdateRequest) {
        userService.updateUser(userId, userUpdateRequest);
        return ResponseEntity.ok("User updated successfully!");
    }

    @DeleteMapping("/user/{userId}")
    @PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
        return ResponseEntity.ok(new ApiResponse("User deleted successfully!"));
    }

    @GetMapping("/user/{userId}/tasks")
    public List<TaskResponse> getUserTasks(@PathVariable Long userId) {
        return userService.getUserTasks(userId);
    }
}
