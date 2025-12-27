package com.constructors.level1;

public class Person {
	private String Name;
	private int Age;
	
	public Person() {
		this.Name="Harry";
		this.Age=21;
	}
	public Person(String Name,int Age) {
		this.Name = Name;
		this.Age = Age;
	}
	// Copy constructor (clones another Person)
	public Person(Person other) {
		this.Name = other.Name;
		this.Age = other.Age;
	}
	public String getName() {
		return Name;
	}
	public int getAge() {
		return Age;
	}
	// For displaying details
	public void display() {
		System.out.println("Name: "+ Name);
		System.out.println("Age: " + Age);
	}
	public static void main(String[] args) {
		Person p1 = new Person("Henry", 25);
	    Person p2 = new Person(p1);
	    p1.display();
	    p2.display();
	}
}