package com.universitycoursemanagementsystem;
public abstract class Enrollment implements Graded {

    protected Student student;
    protected Course course;
    protected Faculty faculty;

    public Enrollment(Student s, Course c, Faculty f) {
        this.student = s;
        this.course = c;
        this.faculty = f;
    }

    public abstract void assignGrade(double marks);

    public void showEnrollment() {
        System.out.println(student.getName() +
                " enrolled in " + course.getTitle() +
                " under " + faculty);
    }
}
