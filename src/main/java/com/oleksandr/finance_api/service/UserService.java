package com.oleksandr.finance_api.service;

import com.oleksandr.finance_api.entity.User;
import com.oleksandr.finance_api.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    // Spring injects the userRepository and passwordEncoder into the service
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder){
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    // Create user
    public User createUser(String name, String email, String password){
        if(userRepository.existsByEmail(email)){
            throw new IllegalArgumentException("Email already exists");
        }
        User user = new User();

        String passwordHash = passwordEncoder.encode(password);
        user.setName(name);
        user.setEmail(email);
        user.setPasswordHash(passwordHash);

        // After saving, PostgreSQL generates id -> Jpa returns persisted entity including this ID
        return userRepository.save(user);
    }

}
