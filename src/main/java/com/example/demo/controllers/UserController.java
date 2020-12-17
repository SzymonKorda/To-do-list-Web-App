package com.example.demo.controllers;

import com.example.demo.model.User;
import com.example.demo.services.UserService;
import org.springframework.web.bind.annotation.*;


@RestController
public class UserController {

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/user")
    public void createFilm(@RequestBody User user) {
        userService.newUser(user);
    }

    @GetMapping("/user/{userId}")
    public User getFilm(@PathVariable long userId) {
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
}
