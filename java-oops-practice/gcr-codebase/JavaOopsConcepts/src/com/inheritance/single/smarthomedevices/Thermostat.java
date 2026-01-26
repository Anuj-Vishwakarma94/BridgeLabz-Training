package com.inheritance.single.smarthomedevices;

public class Thermostat extends Device {

    private int temperatureSetting;

    // Constructor to initialize thermostat details
    public Thermostat(String deviceId, String status, int temperatureSetting) {
        super(deviceId, status);
        this.temperatureSetting = temperatureSetting;
    }

    // Overridden method to display thermostat-specific status
    @Override
    public void displayStatus() {
        super.displayStatus();
        System.out.println("Temperature Setting : " + temperatureSetting + "°C");
    }
}
