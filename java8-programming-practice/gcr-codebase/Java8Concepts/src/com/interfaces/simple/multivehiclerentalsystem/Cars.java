package com.interfaces.simple.multivehiclerentalsystem;

public class Cars  implements RentalSystem {

	
	private Boolean status;
	
	public Cars() {
		this.status = false;
	}
	
	@Override
	public void rent() {
		// TODO Auto-generated method stub
		status = true;
		System.out.println("Car Rentad Successfully");
	}

	@Override
	public void returnVehicle() {
		// TODO Auto-generated method stub
		status = true;
		System.out.println("Car Returned Successfully\n");
	}

}
