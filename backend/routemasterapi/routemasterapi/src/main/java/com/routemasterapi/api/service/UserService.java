package com.routemasterapi.api.service;

import com.routemasterapi.api.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import com.routemasterapi.api.entity.User;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private EmailService emailService;

    // Register a new user
    public User registerUser(User user) {
        User newUser = new User();
        newUser.setFirstName(user.getFirstName());
        newUser.setLastName(user.getLastName());
        newUser.setEmail(user.getEmail());
        newUser.setPassword(user.getPassword());
        newUser.setPhoneNumber(user.getPhoneNumber());

        // Save the new user to the database
        User savedUser = userRepository.save(newUser);

        // Send the email to the registered user
        emailService.sendEmail(
                savedUser.getEmail(), // Use the email of the saved user
                "Registration Successful",
                String.format("Hi %s %s, you have successfully registered on Smart Logistics.", savedUser.getFirstName(), savedUser.getLastName())
        );

        // Return the saved user
        return savedUser;
    }



    // Authenticate user by email and password
    public Optional<User> authenticateUser(String email, String password) {
        User user = userRepository.findByEmail(email);
        if (user != null && user.getPassword().equals(password)) {
            return Optional.of(user);
        }
        return Optional.empty();
    }

    // Fetch user by ID
    public Optional<User> getUserById(int userId) {
        return userRepository.findById(userId);
    }

    // Update user details
    public User updateUser(User user) {
        return userRepository.save(user);
    }

    // Delete user
    public void deleteUser(int userId) {
        userRepository.deleteById(userId);
    }



}
