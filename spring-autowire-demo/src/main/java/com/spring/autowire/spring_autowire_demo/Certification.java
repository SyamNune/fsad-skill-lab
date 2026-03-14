package com.spring.autowire.spring_autowire_demo;

import org.springframework.stereotype.Component;

@Component
public class Certification {

    private int id = 201;
    private String name = "Spring Framework Certification";
    private String dateOfCompletion = "2026";

    public String toString() {
        return "Certification ID: " + id +
               "\nCertification Name: " + name +
               "\nDate Of Completion: " + dateOfCompletion;
    }
}