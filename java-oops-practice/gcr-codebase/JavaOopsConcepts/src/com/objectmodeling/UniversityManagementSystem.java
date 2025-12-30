package com.objectmodeling;
import java.util.Scanner;

public class UniversityManagementSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Student2 student1 = new Student2("Aryan");
        Student2 student2 = new Student2("Mehul");

        Professor professor1 = new Professor("Dr. Lipika");

        Course2 course1 = new Course2("Data Structures");
        Course2 course2 = new Course2("Operating Systems");

        student1.enrollCourse(course1);
        student2.enrollCourse(course1);
        student1.enrollCourse(course2);

        professor1.assignCourse(course1);
        professor1.assignCourse(course2);

        student1.showCourses();
        student2.showCourses();

        professor1.showCourses();

        course1.showCourseDetails();
        course2.showCourseDetails();
        sc.close();
    }
}