package com.inheritance.hierarchical.animalhierarchy;

public class Bird extends Animal{
	public Bird(String name, int age) {
        super(name, age);
    }
    public void makeSound() {
        System.out.println(name + " says: Chirp Chirp");
    }
}
