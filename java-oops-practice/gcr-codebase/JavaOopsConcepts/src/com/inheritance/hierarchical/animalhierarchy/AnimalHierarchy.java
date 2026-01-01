package com.inheritance.hierarchical.animalhierarchy;

public class AnimalHierarchy {
	public static void main(String[] args) {
        Animal animal1 = new Dog("Shero", 3);
        Animal animal2 = new Cat("Mee-chan", 2);
        Animal animal3 = new Bird("Peeko", 1);

        animal1.makeSound();
        animal2.makeSound();
        animal3.makeSound();
    }
}

