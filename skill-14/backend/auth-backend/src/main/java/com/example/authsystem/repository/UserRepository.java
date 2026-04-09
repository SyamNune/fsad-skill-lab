package com.example.authsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.authsystem.model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsernameAndPassword(String username, String password);
}