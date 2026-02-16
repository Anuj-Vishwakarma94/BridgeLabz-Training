package com.jdbc.transactionmanagement;

import java.sql.*;
import java.util.Scanner;

public class BankingSystem{

    static final String url = "jdbc:mysql://localhost:3306/sqlpractice";
    static final String username = "root";
    static final String password = "Gamebit@8878";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while(true) {

            System.out.println("\n===== Banking System =====");
            System.out.println("1. Transfer Money");
            System.out.println("2. Check Balance");
            System.out.println("3. Transaction History");
            System.out.println("4. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch(choice) {

                case 1: transferMoney(); break;
                case 2: checkBalance(); break;
                case 3: transactionHistory(); break;
                case 4: System.exit(0);

                default:
                    System.out.println("Invalid choice");
            }
        }
    }

    // ============================================
    // Transfer Money using Transaction
    // ============================================
    static void transferMoney() {

        try(Connection con = DriverManager.getConnection(url, username, password)) {

            System.out.print("From Account ID: ");
            int from = sc.nextInt();

            System.out.print("To Account ID: ");
            int to = sc.nextInt();

            System.out.print("Amount: ");
            double amount = sc.nextDouble();

            // Disable auto commit
            con.setAutoCommit(false);

            // Check sender balance
            PreparedStatement checkStmt =
                    con.prepareStatement("SELECT balance FROM accounts WHERE account_id=?");

            checkStmt.setInt(1, from);

            ResultSet rs = checkStmt.executeQuery();

            if(!rs.next()) {
                System.out.println("Sender account not found");
                return;
            }

            double balance = rs.getDouble("balance");

            if(balance < amount) {
                System.out.println("Insufficient balance");
                return;
            }

            // Deduct from sender
            PreparedStatement deductStmt =
                    con.prepareStatement("UPDATE accounts SET balance=balance-? WHERE account_id=?");

            deductStmt.setDouble(1, amount);
            deductStmt.setInt(2, from);

            deductStmt.executeUpdate();

            // Add to receiver
            PreparedStatement addStmt =
                    con.prepareStatement("UPDATE accounts SET balance=balance+? WHERE account_id=?");

            addStmt.setDouble(1, amount);
            addStmt.setInt(2, to);

            addStmt.executeUpdate();

            // Insert transaction history
            PreparedStatement insertStmt =
                    con.prepareStatement(
                            "INSERT INTO transactions(from_account, to_account, amount) VALUES (?, ?, ?)");

            insertStmt.setInt(1, from);
            insertStmt.setInt(2, to);
            insertStmt.setDouble(3, amount);

            insertStmt.executeUpdate();

            // Commit transaction
            con.commit();

            System.out.println("Transfer Successful");

        } catch(Exception e) {

            System.out.println("Transfer Failed");
            System.out.println(e);
        }
    }

    // ============================================
    // Check Balance
    // ============================================
    static void checkBalance() {

        try(Connection con = DriverManager.getConnection(url, username, password)) {

            System.out.print("Enter Account ID: ");
            int id = sc.nextInt();

            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM accounts WHERE account_id=?");

            ps.setInt(1, id);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                System.out.println("Account ID: " + rs.getInt("account_id"));
                System.out.println("Name: " + rs.getString("account_holder"));
                System.out.println("Balance: " + rs.getDouble("balance"));
            }
            else {
                System.out.println("Account not found");
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // ============================================
    // Transaction History
    // ============================================
    static void transactionHistory() {

        try(Connection con = DriverManager.getConnection(url, username, password)) {

            PreparedStatement ps =
                    con.prepareStatement("SELECT * FROM transactions");

            ResultSet rs = ps.executeQuery();

            while(rs.next()) {

                System.out.println(
                        "Transaction ID: " + rs.getInt("transaction_id") +
                        " From: " + rs.getInt("from_account") +
                        " To: " + rs.getInt("to_account") +
                        " Amount: " + rs.getDouble("amount") +
                        " Date: " + rs.getTimestamp("transaction_date")
                );
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
