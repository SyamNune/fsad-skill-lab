package com.spring.autowire.spring_autowire_demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id = 1;
    private String name = "Syam";
    private String gender = "Male";

    @Autowired
    private Certification certification;

    public void displayStudent() {

        System.out.println("Student ID: " + id);
        System.out.println("Name: " + name);
        System.out.println("Gender: " + gender);

        System.out.println(certification);
    }
}