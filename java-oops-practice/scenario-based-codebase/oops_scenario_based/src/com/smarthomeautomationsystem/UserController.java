package com.smarthomeautomationsystem;
public class UserController {

    public void turnOnDevice(Controllable device) {
        device.turnOn();
    }

    public void turnOffDevice(Controllable device) {
        device.turnOff();
    }

    public void showApplianceStatus(Appliance a) {
        a.showStatus();
    }
}
