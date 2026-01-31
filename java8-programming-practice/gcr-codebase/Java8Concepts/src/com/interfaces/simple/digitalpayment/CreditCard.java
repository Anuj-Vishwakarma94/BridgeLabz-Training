package com.interfaces.simple.digitalpayment;

public class CreditCard implements DigitalPayment {

	private Boolean status;
	
	public CreditCard() {
		this.status = false;
			
	}

	public void pay() {
		// TODO Auto-generated method stub
		status = true;
		System.out.println("Payment SuccessFull through CreditCard");
	}
}

