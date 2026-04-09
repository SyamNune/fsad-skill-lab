package com.skill13.backend;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "*")
public class MessageController {

    @GetMapping("/message")
    public String getMessage() {
        return "Hello from Spring Boot Backend 🚀";
    }
}