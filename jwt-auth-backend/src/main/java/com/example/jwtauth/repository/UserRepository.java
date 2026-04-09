package com.example.jwtauth.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.jwtauth.entity.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}