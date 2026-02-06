package com.functionalinterface.custom;

public class CustomFunctionalMain {

    public static void main(String[] args) {

        BonusCalculator bonus =
                salary -> salary * 0.10;
        System.out.println(bonus.calculate(50000));

        LoanEligibilityChecker loanCheck =
                salary -> salary >= 30000;
        System.out.println(loanCheck.check(28000));

        TaxCalculator tax =
                income -> income * 0.15;
        System.out.println(tax.calculate(60000));

        LoginValidator login =
                (u, p) -> u.equals("admin") && p.equals("1234");
        System.out.println(login.validate("admin", "1234"));
    }
}

