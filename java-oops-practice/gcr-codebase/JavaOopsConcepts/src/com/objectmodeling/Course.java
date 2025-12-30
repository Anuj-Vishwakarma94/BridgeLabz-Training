package com.objectmodeling;
import java.util.ArrayList;

public class Course {

    String coursename;
    ArrayList<Student> studentlist = new ArrayList<>();

    Course(String coursename) {
        this.coursename = coursename;
    }

    void addStudent(Student student) {
        studentlist.add(student);
    }

    void showStudents() {
        System.out.println("Students in " + coursename + ":");
        for (Student student : studentlist) {
            System.out.println(student.studentname);
        }
        System.out.println();
    }
}