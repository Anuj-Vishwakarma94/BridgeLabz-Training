package com.smarthomeautomationsystem;
public class Light extends Appliance {

    public Light(String name) {
        super(name, 60);   // default 60W bulb
    }

    public Light(String name, double power) {
        super(name, power);
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println(name + " Light turned ON (Soft glow).");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println(name + " Light turned OFF.");
    }

    @Override
    public void showStatus() {
        System.out.println(name + " Light | Power: " + getPowerUsage() +
                "W | Status: " + (isOn() ? "ON" : "OFF"));
    }
}
