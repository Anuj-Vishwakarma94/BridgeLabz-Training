package com.studentmanagement.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.studentmanagement.model.Address;
import com.studentmanagement.model.Student;
import com.studentmanagement.service.StudentService;

@Configuration
public class AppConfig {

    @Bean
    public Address address() {
        return new Address("Bhopal", "Madhya Pradesh");
    }

    @Bean
    public Student student() {

        Student student = new Student();

        student.setId(101);
        student.setName("Anuj");
        student.setAddress(address());

        return student;
    }

    @Bean
    public StudentService studentService() {
        return new StudentService(student());
    }
}