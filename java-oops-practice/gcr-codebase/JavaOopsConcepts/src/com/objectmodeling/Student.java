package com.objectmodeling;
	import java.util.ArrayList;

	public class Student {

	    String studentname;
	    ArrayList<Course> courselist = new ArrayList<>();

	    Student(String studentname) {
	        this.studentname = studentname;
	    }

	    void enrollCourse(Course course) {
	        courselist.add(course);
	        course.addStudent(this);
	    }

	    void showCourses() {
	        System.out.println(studentname + " enrolled courses:");
	        for (Course course : courselist) {
	            System.out.println(course.coursename);
	        }
	        System.out.println();
	  }
}

