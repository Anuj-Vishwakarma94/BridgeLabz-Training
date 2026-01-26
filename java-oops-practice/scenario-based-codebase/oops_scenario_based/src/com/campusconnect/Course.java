package com.campusconnect;
 
import java.util.ArrayList;
import java.util.List;

public class Course {

    private String courseName;
    private Faculty faculty;
    private List<Student> students = new ArrayList<>();

    public Course(String courseName, Faculty faculty) {
        this.courseName = courseName;
        this.faculty = faculty;
    }

    public void addStudent(Student s) {
        students.add(s);
    }

    public void removeStudent(Student s) {
        students.remove(s);
    }

    public void printCourseDetails() {
        System.out.println("\nCourse: " + courseName);
        System.out.println("Faculty: " + faculty.name);
        System.out.println("Enrolled Students:");
        for (Student s : students)
            System.out.println(" - " + s.name);
    }
}

