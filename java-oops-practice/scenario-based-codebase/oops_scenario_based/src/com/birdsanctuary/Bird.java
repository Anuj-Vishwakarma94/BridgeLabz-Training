package com.birdsanctuary;

public abstract class Bird {
    protected String id;
    protected String name;
    protected String species;

    public Bird(String id, String name, String species) {
        this.id = id;
        this.name = name;
        this.species = species;
    }

    public void eat() {
        System.out.println(name + " is eating");
    }

    public String getId() {
        return id;
    }

    public void display() {
        System.out.println(id + " " + name + " " + species);
    }
}
