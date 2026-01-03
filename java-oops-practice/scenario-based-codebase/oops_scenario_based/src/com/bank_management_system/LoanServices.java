package com.bank_management_system;
interface LoanServices {
    boolean checkLoanEligibility(Account account);
    double calculateEligibleAmount(Account account);
}