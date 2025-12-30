package com.objectmodeling;

public class Faculty {
	String facultyname;

    Faculty(String facultyname) {
        this.facultyname = facultyname;
    }

    void showFaculty() {
        System.out.println("Faculty: " + facultyname);
    }
}
