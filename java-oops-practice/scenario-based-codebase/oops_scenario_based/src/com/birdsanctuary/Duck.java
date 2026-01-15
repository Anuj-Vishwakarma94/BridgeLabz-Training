package com.birdsanctuary;
public class Duck extends Bird implements Flyable, Swimmable {

    public Duck(String id, String name) {
        super(id, name, "Duck");
    }

    public void fly() {
        System.out.println(name + " is flying");
    }

    public void swim() {
        System.out.println(name + " is swimming");
    }
}
