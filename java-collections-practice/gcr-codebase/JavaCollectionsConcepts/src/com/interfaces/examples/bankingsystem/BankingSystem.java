package com.interfaces.examples.bankingsystem;

import java.util.*;

public class BankingSystem {

    private final Map<String, Double> accounts = new HashMap<>();
    private final TreeMap<Double, List<String>> sortedByBalance =
            new TreeMap<>(Collections.reverseOrder());
    private final Queue<WithdrawalRequest> withdrawalQueue = new LinkedList<>();

    static class WithdrawalRequest {
        String accountNumber;
        double amount;

        WithdrawalRequest(String accountNumber, double amount) {
            this.accountNumber = accountNumber;
            this.amount = amount;
        }

        public String toString() {
            return "Withdraw $" + amount + " from " + accountNumber;
        }
    }

    public void deposit(String accountNumber, double amount) {
        double oldBalance = accounts.getOrDefault(accountNumber, 0.0);
        double newBalance = oldBalance + amount;

        accounts.put(accountNumber, newBalance);
        updateSortedBalance(accountNumber, oldBalance, newBalance);

        System.out.printf("Deposited $%.2f to %s -> Balance: $%.2f%n",
                amount, accountNumber, newBalance);
    }

    public void requestWithdrawal(String accountNumber, double amount) {
        double balance = accounts.getOrDefault(accountNumber, 0.0);

        if (balance < amount) {
            System.out.printf("Insufficient funds in %s (Balance: $%.2f, Requested: $%.2f)%n",
                    accountNumber, balance, amount);
            return;
        }

        withdrawalQueue.offer(new WithdrawalRequest(accountNumber, amount));
        System.out.printf("Withdrawal request of $%.2f from %s added to queue.%n",
                amount, accountNumber);
    }

    public void processWithdrawals() {
        if (withdrawalQueue.isEmpty()) {
            System.out.println("No withdrawal requests pending.");
            return;
        }

        System.out.println("\nProcessing withdrawal requests...\n");

        while (!withdrawalQueue.isEmpty()) {
            WithdrawalRequest req = withdrawalQueue.poll();

            if (!accounts.containsKey(req.accountNumber)) continue;

            double currentBalance = accounts.get(req.accountNumber);
            double newBalance = currentBalance - req.amount;

            accounts.put(req.accountNumber, newBalance);
            updateSortedBalance(req.accountNumber, currentBalance, newBalance);

            System.out.printf("Processed: %s -> New Balance: $%.2f%n",
                    req, newBalance);
        }
    }

    private void updateSortedBalance(String acc, double oldBal, double newBal) {

        if (oldBal > 0 && sortedByBalance.containsKey(oldBal)) {
            List<String> list = sortedByBalance.get(oldBal);
            list.remove(acc);

            if (list.isEmpty()) {
                sortedByBalance.remove(oldBal);
            }
        }

        sortedByBalance
                .computeIfAbsent(newBal, k -> new ArrayList<>())
                .add(acc);
    }

    public void displayAccounts() {
        System.out.println("\n=== Banking System Status ===\n");

        System.out.println("HashMap (Account Balances):");
        accounts.forEach((acc, bal) ->
                System.out.printf("  %s -> $%.2f%n", acc, bal));

        System.out.println("\nTreeMap (Sorted by Balance):");
        sortedByBalance.forEach((bal, accList) ->
                accList.forEach(acc ->
                        System.out.printf("  $%.2f -> %s%n", bal, acc)));

        System.out.println("\nPending Withdrawal Queue:");
        System.out.println(withdrawalQueue);
        System.out.println("----------------------------------------");
    }

    public static void main(String[] args) {
        BankingSystem bank = new BankingSystem();

        bank.deposit("ACC001", 50000);
        bank.deposit("ACC002", 150000);
        bank.deposit("ACC003", 75000);
        bank.deposit("ACC004", 20000);

        bank.displayAccounts();

        bank.requestWithdrawal("ACC002", 30000);
        bank.requestWithdrawal("ACC001", 10000);
        bank.requestWithdrawal("ACC003", 80000);
        bank.requestWithdrawal("ACC004", 5000);

        bank.displayAccounts();

        bank.processWithdrawals();

        bank.displayAccounts();
    }
}
