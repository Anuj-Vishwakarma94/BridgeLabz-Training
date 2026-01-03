package com.bankmanagementsystem;
class LoanManager implements LoanServices {

    @Override
    public boolean checkLoanEligibility(Account account) {
        return account.getBalance() >= 10000;
    }

    @Override
    public double calculateEligibleAmount(Account account) {
        return account.getBalance() * 5;
    }

    public double calculateDiscount(Account account, double loanAmount) {
        if (account instanceof SavingsAccount) {
            return loanAmount * 0.02; // 2% discount
        }
        return 0;
    }
}