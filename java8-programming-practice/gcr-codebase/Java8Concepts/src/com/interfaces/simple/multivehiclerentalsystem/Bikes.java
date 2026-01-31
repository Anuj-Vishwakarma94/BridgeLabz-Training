package com.interfaces.simple.multivehiclerentalsystem;

public class Bikes implements RentalSystem {

	
	private Boolean status;
	
	public Bikes() {
		this.status = false;
	}
	
	@Override
	public void rent() {
		// TODO Auto-generated method stub
		status = true;
		System.out.println("Bike Rentad Successfully");
	}

	@Override
	public void returnVehicle() {
		// TODO Auto-generated method stub
		status = true;
		System.out.println("Bike Returned Successfully\n");
	}

}
