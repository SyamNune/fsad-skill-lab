package com.fsad.exam.controller;

import com.fsad.exam.exception.InvalidInputException;
import com.fsad.exam.exception.StudentNotFoundException;
import com.fsad.exam.model.Student;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/student")
public class StudentController {

    Map<Integer, Student> studentDB = new HashMap<>();

    public StudentController() {
        studentDB.put(1, new Student(1, "Rahul", "Computer Science"));
        studentDB.put(2, new Student(2, "Anjali", "Electronics"));
        studentDB.put(3, new Student(3, "Kiran", "Mechanical"));
    }

    @GetMapping("/{id}")
    public Student getStudent(@PathVariable String id) {

        int studentId;

        try {
            studentId = Integer.parseInt(id);
        } catch (NumberFormatException e) {
            throw new InvalidInputException("Student ID must be a number.");
        }

        Student student = studentDB.get(studentId);

        if (student == null) {
            throw new StudentNotFoundException("Student with ID " + studentId + " not found.");
        }

        return student;
    }
}