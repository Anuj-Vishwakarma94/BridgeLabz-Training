package com.university_course_management_system;
public class Postgraduate extends Student {

    public Postgraduate(String id, String name) {
        super(id, name);
    }

    public Postgraduate(String id, String name, String elective) {
        super(id, name, elective);
    }

    @Override
    public void displayInfo() {
        System.out.println("Postgraduate Student => " + getName());
    }
}
