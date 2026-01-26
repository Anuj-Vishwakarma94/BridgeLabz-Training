package com.campusconnect;

import java.util.ArrayList;
import java.util.List;

public class Student extends Person implements CourseActions {

    private List<Course> courses = new ArrayList<>();
    private List<Double> grades = new ArrayList<>();

    public Student(String name, String email, String id) {
        super(name, email, id);
    }

    public void addGrade(double grade) {
        grades.add(grade);
    }

    public double calculateGPA() {
        double total = 0;
        for (double g : grades) total += g;
        return grades.size() > 0 ? total / grades.size() : 0;
    }

    @Override
    public void enrollCourse(Course course) {
        courses.add(course);
        course.addStudent(this);
    }

    @Override
    public void dropCourse(Course course) {
        courses.remove(course);
        course.removeStudent(this);
    }

    @Override
    public void printDetails() {
        System.out.println("Student: " + name +
                ", Email: " + email +
                ", GPA: " + calculateGPA());
    }
}
