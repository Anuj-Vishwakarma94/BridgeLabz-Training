package com.universitycoursemanagementsystem;
public class PassFailEnrollment extends Enrollment {

    public PassFailEnrollment(Student s, Course c, Faculty f) {
        super(s, c, f);
    }

    @Override
    public void assignGrade(double marks) {

        double gradePoints;

        if (marks >= 50)
            gradePoints = 8.0;   // Pass → same GPA weight
        else
            gradePoints = 0.0;   // Fail

        // secure GPA update
        student.updateGPA(gradePoints);
    }
}
