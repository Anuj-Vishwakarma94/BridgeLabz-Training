package com.birdsanctuary;
public class Eagle extends Bird implements Flyable {

    public Eagle(String id, String name) {
        super(id, name, "Eagle");
    }

    public void fly() {
        System.out.println(name + " is flying high");
    }
}
