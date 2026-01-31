package com.interfaces.marker.sensetivedatatagging;

public class BankAccount implements Sensitive {

	 private String accountNumber;

	 public BankAccount(String accountNumber) {
	     this.accountNumber = accountNumber;
	 }

	 public String getAccountNumber() {
	     return accountNumber;
	 }
	}

