package com.bankmanagementsystem;
interface LoanServices {
    boolean checkLoanEligibility(Account account);
    double calculateEligibleAmount(Account account);
}