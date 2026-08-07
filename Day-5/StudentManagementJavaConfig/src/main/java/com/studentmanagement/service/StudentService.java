package com.studentmanagement.service;

import com.studentmanagement.model.Student;

public class StudentService {

    private Student student;

    public StudentService(Student student) {
        this.student = student;
    }

    public void showStudent() {
        student.display();
    }
}