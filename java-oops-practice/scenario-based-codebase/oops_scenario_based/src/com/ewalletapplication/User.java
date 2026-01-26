package com.ewalletapplication;
import java.util.ArrayList;
import java.util.List;

public class User {

    private String userId;
    private String name;
    private Wallet wallet;
    private List<Transaction> history = new ArrayList<>();

    public User(String userId, String name, Wallet wallet) {
        this.userId = userId;
        this.name = name;
        this.wallet = wallet;
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void addTransaction(String details, double amount) {
        history.add(new Transaction(details, amount));
    }

    public void showHistory() {
        System.out.println("\nTransaction History of " + name);
        for (Transaction t : history) t.printTransaction();
    }

    public String getName() {
        return name;
    }
}
