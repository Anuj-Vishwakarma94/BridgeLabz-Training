package com.smarthomeautomationsystem;
public class AC extends Appliance {

    private int temperature;

    public AC(String name) {
        super(name, 1500);
        this.temperature = 24;
    }

    public AC(String name, double power, int temp) {
        super(name, power);
        this.temperature = temp;
    }

    @Override
    public void turnOn() {
        setOn(true);
        System.out.println(name + " AC turned ON. Cooling to " + temperature + "°C");
    }

    @Override
    public void turnOff() {
        setOn(false);
        System.out.println(name + " AC turned OFF.");
    }

    @Override
    public void showStatus() {
        System.out.println(name + " AC | Power: " + getPowerUsage() +
                "W | Temp: " + temperature +
                "°C | Status: " + (isOn() ? "ON" : "OFF"));
    }
}
