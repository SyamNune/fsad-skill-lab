package com.example.jwtauth.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.jwtauth.entity.User;
import com.example.jwtauth.repository.UserRepository;
import com.example.jwtauth.security.JwtUtil;

@RestController
public class AuthController {

    @Autowired
    private UserRepository repo;

    @Autowired
    private JwtUtil jwtUtil;

    @PostMapping("/login")
    public String login(@RequestBody User user) {

        User dbUser = repo.findByUsername(user.getUsername());

        if (dbUser != null && dbUser.getPassword().equals(user.getPassword())) {
            return jwtUtil.generateToken(dbUser.getUsername(), dbUser.getRole());
        }

        throw new RuntimeException("Invalid Credentials");
    }
}