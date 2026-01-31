package com.interfaces.simple.smartdevicecontrol;

public class AC implements SmartDevice {

	private Boolean status;
	
	public AC() {
		this.status = false;
	}

	public void turnOn() {
		// TODO Auto-generated method stub
		status = true;
		System.out.println("AC Turned ON");
	}

	public void turnOff() {
		// TODO Auto-generated method stub
		status = false;
		System.out.println("AC Turned Off\n");
	}
	
}
