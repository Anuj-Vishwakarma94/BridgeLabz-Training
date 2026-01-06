package com.fittrack;

public class UserProfile {

    private String name;
    private int age;
    private double weight;     
    private int dailyTarget;   

    public UserProfile(String name, int age, double weight, int dailyTarget) {
        this.name = name;
        this.age = age;
        this.weight = weight;
        this.dailyTarget = dailyTarget;
    }
    
    public String name() {
        return name;
    }
    
    public int age() {
        return age;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        if(weight > 0)
            this.weight = weight;
    }

    public int getDailyTarget() {
        return dailyTarget;
    }
}
