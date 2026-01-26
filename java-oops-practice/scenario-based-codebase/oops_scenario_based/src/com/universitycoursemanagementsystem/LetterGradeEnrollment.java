package com.universitycoursemanagementsystem;
public class LetterGradeEnrollment extends Enrollment {

    public LetterGradeEnrollment(Student s, Course c, Faculty f) {
        super(s, c, f);
    }

    @Override
    public void assignGrade(double marks) {

        double gradePoints;

        if (marks >= 90) gradePoints = 10;
        else if (marks >= 80) gradePoints = 9;
        else if (marks >= 70) gradePoints = 8;
        else if (marks >= 60) gradePoints = 7;
        else if (marks >= 50) gradePoints = 6;
        else gradePoints = 0;

        student.updateGPA(gradePoints);
    }
}
