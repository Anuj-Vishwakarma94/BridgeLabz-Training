package com.fitnesstracker;
public class User {

    private String name;
    private int steps;

    public User(String name, int steps) {
        this.name = name;
        this.steps = steps;
    }

    public String getName() {
        return name;
    }

    public int getSteps() {
        return steps;
    }

    public void setSteps(int steps) {
        this.steps = steps;
    }
}
