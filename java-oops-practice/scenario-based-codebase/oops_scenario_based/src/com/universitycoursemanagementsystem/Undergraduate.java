package com.universitycoursemanagementsystem;
public class Undergraduate extends Student {

    public Undergraduate(String id, String name) {
        super(id, name);
    }

    public Undergraduate(String id, String name, String elective) {
        super(id, name, elective);
    }

    @Override
    public void displayInfo() {
        System.out.println("Undergraduate Student => " + getName());
    }
}
