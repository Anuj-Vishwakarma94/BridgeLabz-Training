package com.petpal;

public class Dog extends Pet {
    public Dog(String name, int age) {
        super(name, "Dog", age);
    }

    @Override
    public void makeSound() {
        System.out.println(name + " says: Woof! Woof!");
    }
}
