package com.interfaces.simple.smartdevicecontrol;

public class Lights implements SmartDevice {

	private Boolean status;
	
	public Lights() {
		this.status = false;
	}

	public void turnOn() {
		// TODO Auto-generated method stub
		status = true;
		System.out.println("Lights Turned ON");
	}

	public void turnOff() {
		// TODO Auto-generated method stub
		status = false;
		System.out.println("Lights Turned Off\n");
	}
	
}
