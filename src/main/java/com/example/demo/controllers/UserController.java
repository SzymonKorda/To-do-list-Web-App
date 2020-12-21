package com.example.demo.controllers;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    @PreAuthorize("hasAuthority('student:write')")
    public void createUser(@RequestBody User user) {
        userService.newUser(user);
    }

    @GetMapping("/user/{userId}")
    @PreAuthorize("hasAnyRole('ROLE_ADMIN', 'ROLE_ADMINTRAINEE')")
    public User getUser(@PathVariable long userId) {
        return userService.getUser(userId);
    }

    @PostMapping("/user/{userId}")
    public void updateUser(@PathVariable long userId, @RequestBody User user) {
        userService.updateUser(userId, user);
    }

    @DeleteMapping("/user/{userId}")
    @PreAuthorize("hasAuthority('student:write')")
    public void deleteUser(@PathVariable Long userId) {
        userService.deleteUser(userId);
    }

    @GetMapping("/user/{userId}/tasks")
    public List<Task> getAllTasks(@PathVariable Long userId) {
        return userService.getUserTasks(userId);
    }
}
