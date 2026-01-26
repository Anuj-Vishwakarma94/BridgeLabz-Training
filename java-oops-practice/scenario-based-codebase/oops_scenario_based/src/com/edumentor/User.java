package com.edumentor;
public class User {
    protected String name;
    protected String email;
    protected String userId;

    public User(String name, String email, String userId) {
        this.name = name;
        this.email = email;
        this.userId = userId;
    }

    public void displayDetails() {
        System.out.println("Name: " + name + ", Email: " + email + ", UserId: " + userId);
    }
}
