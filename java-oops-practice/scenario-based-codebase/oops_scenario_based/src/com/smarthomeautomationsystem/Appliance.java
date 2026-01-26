package com.smarthomeautomationsystem;
public abstract class Appliance implements Controllable {

    private boolean isOn;
    private double powerUsage;   // watts

    protected String name;

    // Default constructor
    public Appliance(String name) {
        this.name = name;
        this.powerUsage = 100;   // default
        this.isOn = false;
    }

    // Custom power constructor
    public Appliance(String name, double powerUsage) {
        this.name = name;
        this.powerUsage = powerUsage;
        this.isOn = false;
    }

    public boolean isOn() { return isOn; }

    public double getPowerUsage() { return powerUsage; }

    protected void setOn(boolean on) {
        this.isOn = on;
    }

    public void compareUsage(Appliance other) {
        if (this.powerUsage > other.powerUsage)
            System.out.println(this.name + " uses MORE power than " + other.name);
        else if (this.powerUsage < other.powerUsage)
            System.out.println(this.name + " uses LESS power than " + other.name);
        else
            System.out.println(this.name + " uses SAME power as " + other.name);
    }

    public abstract void showStatus();
}
