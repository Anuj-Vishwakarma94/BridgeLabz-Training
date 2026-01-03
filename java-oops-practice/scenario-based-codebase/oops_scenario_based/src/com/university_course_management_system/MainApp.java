package com.university_course_management_system;
public class MainApp {

    public static void main(String[] args) {

        Student s1 = new Undergraduate("U101", "Rohan Cariappa");
        Student s2 = new Postgraduate("P501", "Shaby", "AI");

        Course c1 = new Course("CS101", "OOP in Java", 4);
        Course c2 = new Course("CS505", "Data Science", 3);

        Faculty f1 = new Faculty("F01", "Dr. Mehta");

        s1.displayInfo();
        s2.displayInfo();

        System.out.println();

        Enrollment e1 = new LetterGradeEnrollment(s1, c1, f1);
        Enrollment e2 = new PassFailEnrollment(s2, c2, f1);

        // Polymorphism in assigning grades
        e1.assignGrade(82);   // Letter Grade
        e2.assignGrade(48);   // Pass/Fail

        System.out.println("\n--- TRANSCRIPTS ---");
        System.out.println(s1.getTranscript());
        System.out.println(s2.getTranscript());
    }
}
