package com.interfaces.simple.digitalpayment;

public class UPI implements DigitalPayment{

	private Boolean status;
	
	public UPI() {
		this.status = false;
			
	}

	@Override
	public void pay() {
		// TODO Auto-generated method stub
		status = true;
		System.out.println("Payment SuccessFull through UPI");
	}
}
