package com.oleksandr.finance_api.controller;

import com.oleksandr.finance_api.dto.RegisterUserRequest;
import com.oleksandr.finance_api.dto.UserResponse;
import com.oleksandr.finance_api.entity.User;
import com.oleksandr.finance_api.service.UserService;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// Thie class handles HTTP requests and return response data
@RestController
// All endpoints start with /users
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    // UserService is injected through constructor Dependency Injection
    public UserController(UserService userService){
        this.userService = userService;
    }

    // Methods that handles POST /users/register
    @PostMapping("/register")
    public UserResponse registerUser(@Valid @RequestBody RegisterUserRequest request){
        User user = userService.createUser(
                request.getName(),
                request.getEmail(),
                request.getPassword()
        );
        return new UserResponse(
                user.getId(),
                user.getName(),
                user.getEmail()
        );
    }
}
