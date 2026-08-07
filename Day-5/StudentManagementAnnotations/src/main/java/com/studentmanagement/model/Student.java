package com.studentmanagement.model;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Student {

    private int id = 101;
    private String name = "Anuj";

    @Autowired
    private Address address;

    public void display() {

        System.out.println("Student ID : " + id);
        System.out.println("Student Name : " + name);
        System.out.println("City : " + address.getCity());
        System.out.println("State : " + address.getState());
    }
}