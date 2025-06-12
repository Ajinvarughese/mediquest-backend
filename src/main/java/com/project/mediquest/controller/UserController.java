package com.project.mediquest.controller;

import com.project.mediquest.entities.User;
import com.project.mediquest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/users")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public User registerUser(@RequestBody User user) {
        return userService.registerUser(user);
    }

    @PostMapping("/login")
    public String login(@RequestBody User user) {
        boolean isAuthenticated = userService.authenticate(user.getUsername(), user.getPassword());
        if (isAuthenticated) {
            return "Login successful for user: " + user.getUsername();
        } else {
            return "Invalid credentials";
        }
    }

    @GetMapping("/{username}")
    public Optional<User> getUserByUsername(@PathVariable String username) {
        return userService.findByUsername(username);
}
}

