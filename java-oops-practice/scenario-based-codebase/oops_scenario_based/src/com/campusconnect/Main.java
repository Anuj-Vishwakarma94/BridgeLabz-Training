package com.campusconnect;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Faculty input
        System.out.println("Enter Faculty Details:");
        System.out.print("Name: ");
        String fname = sc.nextLine();

        System.out.print("Email: ");
        String femail = sc.nextLine();

        System.out.print("ID: ");
        String fid = sc.nextLine();

        Faculty faculty = new Faculty(fname, femail, fid);

        // Course input
        System.out.print("\nEnter Course Name: ");
        String cname = sc.nextLine();

        Course course = new Course(cname, faculty);

        // Number of students
        System.out.print("\nHow many students to enroll? ");
        int n = sc.nextInt();
        sc.nextLine(); 

        List<Student> students = new ArrayList<>();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nEnter Student " + i + " Details:");

            System.out.print("Name: ");
            String sname = sc.nextLine();

            System.out.print("Email: ");
            String semail = sc.nextLine();

            System.out.print("ID: ");
            String sid = sc.nextLine();

            Student student = new Student(sname, semail, sid);

            // Enroll student
            student.enrollCourse(course);

            // Grades input
            System.out.print("How many grades to enter for " + sname + "? ");
            int gcount = sc.nextInt();

            for (int g = 1; g <= gcount; g++) {
                System.out.print("Enter grade " + g + ": ");
                double grade = sc.nextDouble();
                student.addGrade(grade);
            }

            sc.nextLine(); // clear buffer
            students.add(student);
        }

        // Print info
        System.out.println("\n===== DETAILS =====");
        faculty.printDetails();

        for (Student s : students)
            s.printDetails();

        course.printCourseDetails();

        sc.close();
    }
}

