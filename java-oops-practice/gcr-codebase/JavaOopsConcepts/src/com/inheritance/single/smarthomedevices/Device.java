package com.inheritance.single.smarthomedevices;

public class Device {

    protected String deviceId;
    protected String status;

    // Constructor to initialize device details
    public Device(String deviceId, String status) {
        this.deviceId = deviceId;
        this.status = status;
    }

    // Method to display device status
    public void displayStatus() {
        System.out.println("Device ID : " + deviceId);
        System.out.println("Status    : " + status);
    }
}
