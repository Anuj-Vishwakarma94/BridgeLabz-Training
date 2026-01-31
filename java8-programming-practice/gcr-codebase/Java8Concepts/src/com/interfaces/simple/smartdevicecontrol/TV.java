package com.interfaces.simple.smartdevicecontrol;

public class TV implements SmartDevice {

	private Boolean status;
	
	public TV() {
		this.status = false;
	}

	public void turnOn() {
		// TODO Auto-generated method stub
		status = true;
		System.out.println("TV Turned ON");
	}

	public void turnOff() {
		// TODO Auto-generated method stub
		status = false;
		System.out.println("TV Turned Off\n");
	}
	
}
