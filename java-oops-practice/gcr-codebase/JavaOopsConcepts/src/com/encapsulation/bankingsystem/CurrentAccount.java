package com.encapsulation.bankingsystem;

public class CurrentAccount extends BankAccount {
	 public CurrentAccount(String accountNumber, String holderName, double balance) {
	        super(accountNumber, holderName, balance);
	    }

	    @Override
	    public double calculateInterest() {
	        return 0; // No interest for current accounts
	    }
}
