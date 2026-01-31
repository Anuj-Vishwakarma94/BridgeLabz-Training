package com.interfaces.simple.digitalpayment;

public class Wallet implements DigitalPayment {

	private Boolean status;
	
	public Wallet() {
		this.status = false;
			
	}

	public void pay() {
		// TODO Auto-generated method stub
		status = true;
		System.out.println("Payment SuccessFull through Wallet");
	}
}
