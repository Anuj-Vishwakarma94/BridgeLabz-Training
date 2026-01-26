package com.petpal;

import java.util.Random;
public abstract class Pet implements IInteractable {

    protected String name;
    protected String type;
    protected int age;

    private int hunger;   
    private int mood;    
    private int energy;   

    Random integer = new Random();

    public Pet(String name, String type, int age) {
        this.name = name;
        this.type = type;
        this.age = age;

        this.hunger = integer.nextInt(41) + 30; 
        this.mood = integer.nextInt(41) + 30;
        this.energy = integer.nextInt(41) + 30;
    }

    public int getHunger() { 
    	return hunger; 
    	}
    public int getMood() {
    	return mood; 
    	}
    public int getEnergy() { 
    	return energy;
    	}

    protected void changeHunger(int value) {
        hunger = Math.max(0, Math.min(100, hunger + value));
    }

    protected void changeMood(int value) {
        mood = Math.max(0, Math.min(100, mood + value));
    }

    protected void changeEnergy(int value) {
        energy = Math.max(0, Math.min(100, energy + value));
    }

    public abstract void makeSound();

    @Override
    public void feed() {
        System.out.println(name + " is eating...");
        changeHunger(-20);
        changeMood(+10);
        changeEnergy(+5);
    }

    @Override
    public void play() {
        System.out.println(name + " is playing...");
        changeMood(+15);
        changeEnergy(-15);
        changeHunger(+10);
    }

    @Override
    public void sleep() {
        System.out.println(name + " is sleeping...");
        changeEnergy(+30);
        changeHunger(+10);
    }

    public void showStatus() {
        System.out.println("\nPet Status of " + name);
        System.out.println("Type: " + type);
        System.out.println("Age: " + age);
        System.out.println("Hunger: " + hunger);
        System.out.println("Mood: " + mood);
        System.out.println("Energy: " + energy);
    }
}
