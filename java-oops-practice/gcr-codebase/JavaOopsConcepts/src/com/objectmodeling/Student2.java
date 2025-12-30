package com.objectmodeling;
	import java.util.ArrayList;

	public class Student2 {

	    String studentname;
	    ArrayList<Course2> courselist = new ArrayList<>();

	    Student2(String studentname) {
	        this.studentname = studentname;
	    }

	    void enrollCourse(Course2 course) {
	        courselist.add(course);
	        course.addStudent(this);
	        System.out.println(studentname + " enrolled in " + course.coursename);
	    }

	    void showCourses() {
	        System.out.println(studentname + " enrolled courses:");
	        for (Course2 course : courselist) {
	            System.out.println(course.coursename);
	        }
	        System.out.println();
	    
	}

}
