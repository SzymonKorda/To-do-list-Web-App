package com.example.demo.services;

import com.example.demo.model.Task;
import com.example.demo.model.User;
import com.example.demo.repositories.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService{

    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void newUser(User userRequest) {
        User user = new User();
        user.setFirstName(userRequest.getFirstName());
        user.setLastName(userRequest.getLastName());
        userRepository.save(user);
    }

    @Override
    public User getUser(Long userId) {
        User user = userRepository.findById(userId).get();
        return user;
    }

    @Override
    public void updateUser(Long userId, User userResponse) {
        User user = userRepository.findById(userId).get();
        user.setFirstName(userResponse.getFirstName());
        user.setLastName(userResponse.getLastName());
        userRepository.save(user);
    }

    @Override
    public void deleteUser(Long userId) {
        User user = userRepository.findById(userId).get();
        userRepository.delete(user);
    }

    @Override
    public List<Task> getUserTasks(Long userID) {
        User user = userRepository.findById(userID).get();
        return user.getTasks();
    }
}
