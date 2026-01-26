package com.constructors.level1;

public class PostgraduateStudent extends Student{
	String specialization;
	public PostgraduateStudent(int rollNumber, String name, double cgpa, String specialization) {
		super(rollNumber, name, cgpa);
		this.specialization = specialization;
	}
	public void displayPGDetails() {
		System.out.println("PG Student Name: " + name); 
		System.out.println("Roll Number: " + rollNumber);  
	    System.out.println("Specialization: " + specialization);
	    System.out.println("CGPA: " + getCGPA());          
	}
	public static void main(String[] args) {
		PostgraduateStudent pg = new PostgraduateStudent(201, "Harry", 8.8, "Data Science");
	    pg.displayPGDetails();
	    pg.setCGPA(9.2);
	    System.out.println("Updated CGPA: " + pg.getCGPA());
	}
}