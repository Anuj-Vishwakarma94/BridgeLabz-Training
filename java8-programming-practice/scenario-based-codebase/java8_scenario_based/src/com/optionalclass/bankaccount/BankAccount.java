package com.optionalclass.bankaccount;

import java.util.Optional;

public class BankAccount {

    private String accountNumber;
    private Double balance;
    private Nominee nominee;
    private Loan loan;
    private Transaction transaction;
    private CreditCard creditCard;

    public BankAccount(String accountNumber, Double balance, Nominee nominee,
                       Loan loan, Transaction transaction, CreditCard creditCard) {
        this.accountNumber = accountNumber;
        this.balance = balance;
        this.nominee = nominee;
        this.loan = loan;
        this.transaction = transaction;
        this.creditCard = creditCard;
    }

    public Optional<Nominee> getNominee() {
        return Optional.ofNullable(nominee);
    }

    public Optional<Loan> getLoan() {
        return Optional.ofNullable(loan);
    }

    public Optional<Double> getBalance() {
        return Optional.ofNullable(balance);
    }

    public Optional<Transaction> getTransaction() {
        return Optional.ofNullable(transaction);
    }

    public Optional<CreditCard> getCreditCard() {
        return Optional.ofNullable(creditCard);
    }
}

