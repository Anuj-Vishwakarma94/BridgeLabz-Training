package com.constructors.level1;

public class SavingsAccount extends BankAccount{
	
	private double interestRate;
    public SavingsAccount(String accountNumber, String accountHolder,double balance, double interestRate) {
        super(accountNumber, accountHolder, balance);
        this.interestRate = interestRate;
    }

    public void displaySavingsAccountDetails() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHolder);
        System.out.println("Balance: " + getBalance());
        System.out.println("Interest Rate: " + interestRate + "%");
    }

    public static void main(String[] args) {
        SavingsAccount sa = new SavingsAccount("ABC12345", "Harry", 10000, 4.5);
        sa.displaySavingsAccountDetails();
        sa.deposit(2000);
        sa.withdraw(1500);
        sa.displaySavingsAccountDetails();
    }
}