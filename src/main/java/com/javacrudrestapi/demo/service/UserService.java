package com.javacrudrestapi.demo.service;

import com.javacrudrestapi.demo.model.User;
import com.javacrudrestapi.demo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private BCryptPasswordEncoder passwordEncoder;

    public User saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword())); 
        return userRepository.save(user);
    }

    public User getUser(long userId) {
        Optional<User> user = userRepository.findById(userId);
        return user.orElse(null);  
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public User updateUser(long userId, User userDetails) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            User user = existingUser.get();
            user.setUsername(userDetails.getUsername());
            user.setEmail(userDetails.getEmail());
            user.setPassword(userDetails.getPassword());
            return userRepository.save(user);
        }
        return null;  
    }

    public boolean deleteUser(long userId) {
        Optional<User> existingUser = userRepository.findById(userId);
        if (existingUser.isPresent()) {
            userRepository.delete(existingUser.get());
            return true;
        }
        return false;  
    }

    public List<User> getUsersByName(String username) {
        return userRepository.getUsername(username);
    }

    public User getUserById(long userId) {
        return getUser(userId);  
    }
}
