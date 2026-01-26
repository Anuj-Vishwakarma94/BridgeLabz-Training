package com.inheritance.multilevel.educationalcourse;

public class OnlineCourse extends Course {

    protected String platform;
    protected boolean isRecorded;

    // Constructor to initialize online course details
    public OnlineCourse(String courseName, int duration, String platform, boolean isRecorded) {
        super(courseName, duration);
        this.platform = platform;
        this.isRecorded = isRecorded;
    }

    // Overridden method to include online-specific details
    @Override
    public void displayCourseDetails() {
        super.displayCourseDetails();
        System.out.println("Platform    : " + platform);
        System.out.println("Recorded    : " + isRecorded);
    }
}
