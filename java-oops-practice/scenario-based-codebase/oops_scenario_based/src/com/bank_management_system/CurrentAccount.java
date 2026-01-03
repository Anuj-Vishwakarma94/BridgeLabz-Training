package com.bank_management_system;
class CurrentAccount extends Account {
    private double overdraftLimit;

    public CurrentAccount(String accNo, double balance, double overdraftLimit) {
        super(accNo, balance);
        this.overdraftLimit = overdraftLimit;
    }

    @Override
    public void displayAccountDetails() {
        System.out.println("Current Account | Acc No: " + getAccountNumber() +
                " | Balance: " + balance +
                " | Overdraft Limit: " + overdraftLimit);
    }
}
