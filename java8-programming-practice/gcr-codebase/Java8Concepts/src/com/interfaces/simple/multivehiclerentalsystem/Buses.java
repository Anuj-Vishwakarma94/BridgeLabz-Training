package com.interfaces.simple.multivehiclerentalsystem;

public class Buses implements RentalSystem {

	
	private Boolean status;
	
	public Buses() {
		this.status = false;
	}
	
	@Override
	public void rent() {
		// TODO Auto-generated method stub
		status = true;
		System.out.println("Bus Rentad Successfully");
	}

	@Override
	public void returnVehicle() {
		// TODO Auto-generated method stub
		status = true;
		System.out.println("Bus Returned Successfully\n");
	}

}
