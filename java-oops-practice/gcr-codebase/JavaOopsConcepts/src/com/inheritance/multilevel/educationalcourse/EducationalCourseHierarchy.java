package com.inheritance.multilevel.educationalcourse;

public class EducationalCourseHierarchy {

    public static void main(String[] args) {

        // Multilevel inheritance demonstration
        Course course1 = new Course("Java Basics", 40);
        Course course2 = new OnlineCourse("Advanced Java", 60, "Zoom", true);
        Course course3 = new PaidOnlineCourse("Spring Boot", 80, "Udemy", true, 5000, 20);

        course1.displayCourseDetails();
        System.out.println("---------------------");

        course2.displayCourseDetails();
        System.out.println("---------------------");

        course3.displayCourseDetails();
    }
}
