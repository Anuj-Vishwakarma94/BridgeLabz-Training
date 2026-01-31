package com.interfaces.simple.multivehiclerentalsystem;

public class RentalSystemMain {
	
	public static void main(String[] args) {
		
		RentalSystem c1 = new Cars();
		RentalSystem c2 = new Buses();
		RentalSystem c3 = new Bikes();
		
		c1.rent();
		c1.returnVehicle();
		
		c2.rent();
		c3.returnVehicle();
		
		c3.rent();
		c3.returnVehicle();
		
	}
}
