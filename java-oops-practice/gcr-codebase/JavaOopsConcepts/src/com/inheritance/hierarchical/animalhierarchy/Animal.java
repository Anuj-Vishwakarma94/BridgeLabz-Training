package com.inheritance.hierarchical.animalhierarchy;

public class Animal {
	protected String name;
    protected int age;

    // Constructor to initialize animal details
    public Animal(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to be overridden by subclasses
    public void makeSound() {
        System.out.println("Animal makes a sound");
    }
}
