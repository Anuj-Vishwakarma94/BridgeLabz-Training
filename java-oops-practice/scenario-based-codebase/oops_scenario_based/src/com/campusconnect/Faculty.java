package com.campusconnect;

public class Faculty extends Person {

    public Faculty(String name, String email, String id) {
        super(name, email, id);
    }

    @Override
    public void printDetails() {
        System.out.println("Faculty: " + name + ", Email: " + email);
    }
}
