package com.bankmanagementsystem;
class Validator {

    public static boolean validateUserInput(double input) {
        return input >= 0;
    }

    public static void printAccountSummary(Account account) {
        System.out.println("\n--- Account Summary ---");
        account.displayAccountDetails();
        System.out.println("-----------------------\n");
    }
}