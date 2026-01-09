package com.skillforge;

import java.util.Scanner;

public class SkillForgeTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter Instructor Name: ");
        String instructorName = sc.nextLine();
        Instructor instructor = new Instructor(instructorName);

        System.out.print("Enter Student Name: ");
        String studentName = sc.nextLine();
        Student student = new Student(studentName);

        System.out.print("Enter Course Title: ");
        String courseTitle = sc.nextLine();

        System.out.print("Enter number of modules: ");
        int n = sc.nextInt();
        sc.nextLine();

        String[] modules = new String[n];
        for (int i = 0; i < n; i++) {
            System.out.print("Enter module " + (i + 1) + ": ");
            modules[i] = sc.nextLine();
        }

        System.out.println("Select Course Level");
        System.out.println("1. Beginner");
        System.out.println("2. Advanced");
        int choice = sc.nextInt();

        Course course;
        if (choice == 1) {
            course = new BeginnerCourse(courseTitle, instructor, modules);
        } else {
            course = new AdvancedCourse(courseTitle, instructor, modules);
        }

        System.out.print("Enter progress percentage: ");
        int progress = sc.nextInt();
        student.updateProgress(progress);

        System.out.print("Enter final score: ");
        int score = sc.nextInt();
        student.setScore(score);

        if (student.getScore() >= 60) {
            ((ICertifiable) course).generateCertificate();
        } else {
            System.out.println("Certificate not generated. Score too low.");
        }

        sc.close();
    }
}
