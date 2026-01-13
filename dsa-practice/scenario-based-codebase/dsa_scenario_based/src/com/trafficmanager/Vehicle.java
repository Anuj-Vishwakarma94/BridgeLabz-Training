package com.trafficmanager;

class Vehicle {
	String numberPlate;
	Vehicle next;

	Vehicle(String numberPlate) {
		this.numberPlate = numberPlate;
		this.next = null;
	}
}