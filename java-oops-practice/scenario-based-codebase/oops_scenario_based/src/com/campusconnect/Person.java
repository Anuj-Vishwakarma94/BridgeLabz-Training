package com.campusconnect;

public abstract class Person {
    protected String name;
    protected String email;
    protected String id;

    public Person(String name, String email, String id) {
        this.name = name;
        this.email = email;
        this.id = id;
    }

    public abstract void printDetails();
}
