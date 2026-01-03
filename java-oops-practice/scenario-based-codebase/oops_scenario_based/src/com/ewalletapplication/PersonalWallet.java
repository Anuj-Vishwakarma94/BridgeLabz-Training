package com.ewalletapplication;
public class PersonalWallet extends Wallet {

    public PersonalWallet(double initialAmount) {
        super(initialAmount);
        this.dailyLimit = 50000;
    }

    public PersonalWallet(double initialAmount, double referralBonus) {
        super(initialAmount, referralBonus);
        this.dailyLimit = 50000;
    }

    @Override
    public boolean transferTo(User receiver, double amount) {

        if (amount > dailyLimit) {
            System.out.println("Transfer failed: exceeds personal daily limit.");
            return false;
        }

        // 1% tax
        double tax = amount * 0.01;
        double total = amount + tax;

        if (deduct(total)) {
            receiver.getWallet().deposit(amount);
            System.out.println("Personal transfer successful. Tax: ₹" + tax);
            return true;
        }

        System.out.println("Insufficient balance.");
        return false;
    }

    @Override
    public void displayWalletType() {
        System.out.println("Personal Wallet | Balance ₹" + getBalance());
    }
}
