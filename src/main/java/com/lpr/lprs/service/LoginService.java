package com.lpr.lprs.service;

import com.lpr.lprs.model.User;
import com.lpr.lprs.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class LoginService {

    private final UserRepository userRepository;

    // Constructor injection
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean login(String username, String password) {

        // 1. Find user in database
        User user = userRepository.findByUsername(username);

        // 2. Check if user exists
        if (user == null) {
            return false; // username not found
        }

        // 3. Check password
        return user.getPassword().equals(password);
    }
}