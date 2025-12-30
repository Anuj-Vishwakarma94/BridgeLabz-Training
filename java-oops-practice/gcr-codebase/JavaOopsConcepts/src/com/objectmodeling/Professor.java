package com.objectmodeling;
import java.util.ArrayList;

public class Professor {

    String professorname;
    ArrayList<Course2> courselist = new ArrayList<>();

    Professor(String professorname) {
        this.professorname = professorname;
    }

    void assignCourse(Course2 course) {
        courselist.add(course);
        course.assignProfessor(this);
    }

    void showCourses() {
        System.out.println(professorname + " teaches:");
        for (Course2 course : courselist) {
            System.out.println(course.coursename);
        }
        System.out.println();
    }
}
