package com.smarthomeautomationsystem;
public class Fan extends Appliance {

    private int speed;

    public Fan(String name) {
        super(name, 90);
        this.speed = 1;
    }

    public Fan(String name, double power, int speed) {
        super(name, power);
        this.speed = speed;
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println(name + " Fan turned ON at speed " + speed);
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println(name + " Fan turned OFF.");
    }

    @Override
    public void showStatus() {
        System.out.println(name + " Fan | Power: " + getPowerUsage() +
                "W | Speed: " + speed +
                " | Status: " + (isOn() ? "ON" : "OFF"));
    }
}
