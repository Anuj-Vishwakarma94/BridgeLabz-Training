package com.interfaces.simple.smartdevicecontrol;

public class SmartDeviceMain {

	public static void main(String[] args) {
		
		SmartDevice d1 = new Lights();
		SmartDevice d2 = new AC();
		SmartDevice d3 = new TV();
		
		d1.turnOn();
		d1.turnOff();
		
		d2.turnOn();
		d2.turnOff();
		
		d3.turnOn();
		d3.turnOff();
	}
}
