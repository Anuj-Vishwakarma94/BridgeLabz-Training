package com.studentmanagement.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentmanagement.model.Student;

@Service
public class StudentService {

    @Autowired
    private Student student;

    public void showStudent() {
        student.display();
    }
}