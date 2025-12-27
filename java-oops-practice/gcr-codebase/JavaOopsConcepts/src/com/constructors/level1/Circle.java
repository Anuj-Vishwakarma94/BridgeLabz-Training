package com.constructors.level1;

public class Circle {
	private double radius;
	// Parameterized constructor
	public Circle(double radius) {
		this.radius = radius;
	}
	// Default constructor using constructor chaining
	public Circle() {
	    this(1.0);
	}
	public double getRadius() {
	    return radius;
	}
	// method to compute area
	public double getArea() {
	    return Math.PI * radius * radius;
	}
	public static void main(String[] args) {
	    Circle c1 = new Circle();       
	    Circle c2 = new Circle(5.5);
	    System.out.println("Default radius: " + c1.getRadius());
	    System.out.println("User radius: " + c2.getRadius());
	    System.out.println("Area: " + c1.getArea());
	    System.out.println("Area: " + c2.getArea());
	}
}