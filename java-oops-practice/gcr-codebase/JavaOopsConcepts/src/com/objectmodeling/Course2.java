package com.objectmodeling;
import java.util.ArrayList;

public class Course2 {

    String coursename;
    Professor professor;
    ArrayList<Student2> studentlist = new ArrayList<>();

    Course2(String coursename) {
        this.coursename = coursename;
    }

    void addStudent(Student2 student) {
        studentlist.add(student);
    }

    void assignProfessor(Professor professor) {
        this.professor = professor;
        System.out.println(professor.professorname + " assigned to " + coursename);
    }

    void showCourseDetails() {
        System.out.println("Course: " + coursename);

        if (professor != null) {
            System.out.println("Professor: " + professor.professorname);
        }

        System.out.println("Students:");
        for (Student2 student : studentlist) {
            System.out.println(student.studentname);
        }
        System.out.println();
    }
}
