package com.example.student;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int studentId;
    private String name;
    private String course;
    private int year;

    public Student(
        @Value("102") int studentId,
        @Value("Alice") String name,
        @Value("Python") String course,
        @Value("1") int year) {

        this.studentId = studentId;
        this.name = name;
        this.course = course;
        this.year = year;
    }

    public void display() {
        System.out.println(studentId + " " + name + " " + course + " " + year);
    }
}