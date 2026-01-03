package com.universitycoursemanagementsystem;
public abstract class Student {

    private String studentId;
    private String name;
    private double gpa;   // private — encapsulated
    private int completedCourses;

    protected String electivePreference;

    // Constructor without elective
    public Student(String studentId, String name) {
        this.studentId = studentId;
        this.name = name;
        this.gpa = 0.0;
        this.completedCourses = 0;
    }

    // Constructor with elective (overloaded)
    public Student(String studentId, String name, String electivePreference) {
        this(studentId, name);
        this.electivePreference = electivePreference;
    }

    public String getStudentId() { return studentId; }
    public String getName() { return name; }

    // Controlled GPA update
    protected void updateGPA(double gradePoints) {
        gpa = ((gpa * completedCourses) + gradePoints) / (++completedCourses);
    }

    // Public transcript — safe access
    public String getTranscript() {
        return "Student: " + name +
               " | ID: " + studentId +
               " | GPA: " + String.format("%.2f", gpa);
    }

    public abstract void displayInfo();
}
