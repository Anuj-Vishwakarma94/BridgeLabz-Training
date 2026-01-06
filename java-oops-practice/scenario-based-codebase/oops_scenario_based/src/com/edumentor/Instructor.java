package com.edumentor;
public class Instructor extends User {

    public Instructor(String name, String email, String userId) {
        super(name, email, userId);
    }

    public void assignCourse() {
        System.out.println(name + " is assigned to teach a course.");
    }
}
