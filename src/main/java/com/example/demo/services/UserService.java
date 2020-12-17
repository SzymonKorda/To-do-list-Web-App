package com.example.demo.services;

import com.example.demo.model.User;

import java.util.Optional;

public interface UserService {

    void newUser(User user);
    User getUser(Long userId);
    void updateUser(Long userId, User userRequest);
    void deleteUser(Long userId);
}
