package com.constructors.level1;

public class Course {
	String courseName;
    int duration;     
    double fee;

    static String instituteName = "Techie Institute";
    
    Course(String courseName, int duration, double fee) {
        this.courseName = courseName;
        this.duration = duration;
        this.fee = fee;
    }

    void displayCourseDetails() {
        System.out.println("Institute Name: " + instituteName);
        System.out.println("Course Name: " + courseName);
        System.out.println("Duration: " + duration + " months");
        System.out.println("Fee: Rs. " + fee);
    }

    static void updateInstituteName(String newName) {
        instituteName = newName;
    }

    public static void main(String[] args) {

        Course c1 = new Course("Java Programming", 6, 15000);
        Course c2 = new Course("Web Development", 4, 12000);

        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
        System.out.println();
        Course.updateInstituteName("Tech Learning Center");
        c1.displayCourseDetails();
        System.out.println();
        c2.displayCourseDetails();
    }
}