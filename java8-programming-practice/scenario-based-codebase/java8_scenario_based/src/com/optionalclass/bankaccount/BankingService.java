package com.optionalclass.bankaccount;

public class BankingService {

    public static void main(String[] args) {

        BankAccount account = new BankAccount(
                "ACC101",
                null,
                new Nominee("Anuj"),
                new Loan("Home Loan"),
                new Transaction("TXN900"),
                null
        );

        account.getNominee()
                .ifPresent(n -> System.out.println(n.getName()));

        account.getLoan()
                .ifPresent(l -> System.out.println(l.getLoanType()));

        double balance = account.getBalance()
                .orElse(1000.0);

        String refNo = account.getTransaction()
                .map(Transaction::getReferenceNo)
                .orElse("No Transaction");

        account.getCreditCard()
                .ifPresent(c -> System.out.println(c.getCardNumber()));

        System.out.println(balance);
        System.out.println(refNo);
    }
}

