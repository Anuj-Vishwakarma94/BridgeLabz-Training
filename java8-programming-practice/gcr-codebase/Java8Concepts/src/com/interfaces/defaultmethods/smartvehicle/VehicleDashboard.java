package com.interfaces.defaultmethods.smartvehicle;

public interface VehicleDashboard {
	
    public void displaySpeed(int speed);

    public default void displayBatteryLevel(int percentage) {
        System.out.println("Battery Level: " + percentage + "%");
    }
}
