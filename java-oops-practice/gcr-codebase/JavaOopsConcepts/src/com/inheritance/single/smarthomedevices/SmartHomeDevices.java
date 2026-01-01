package com.inheritance.single.smarthomedevices;

public class SmartHomeDevices {

    public static void main(String[] args) {

        // Single inheritance demonstration
        Device device = new Thermostat("TH-101", "ON", 24);

        device.displayStatus();
    }
}
