package com.ewalletapplication;
public class BusinessWallet extends Wallet {

    public BusinessWallet(double initialAmount) {
        super(initialAmount);
        this.dailyLimit = 500000;
    }

    public BusinessWallet(double initialAmount, double referralBonus) {
        super(initialAmount, referralBonus);
        this.dailyLimit = 500000;
    }

    @Override
    public boolean transferTo(User receiver, double amount) {

        if (amount > dailyLimit) {
            System.out.println("Transfer failed: exceeds business daily limit.");
            return false;
        }

        // 2% tax but 5% cashback for big transfers
        double tax = amount * 0.02;
        double cashback = amount >= 100000 ? amount * 0.05 : 0;

        double total = amount + tax - cashback;

        if (deduct(total)) {
            receiver.getWallet().deposit(amount);
            System.out.println("Business transfer successful. Tax: ₹" + tax + ", Cashback: ₹" + cashback);
            return true;
        }

        System.out.println("Insufficient balance.");
        return false;
    }

    @Override
    public void displayWalletType() {
        System.out.println("Business Wallet | Balance ₹" + getBalance());
    }
}
