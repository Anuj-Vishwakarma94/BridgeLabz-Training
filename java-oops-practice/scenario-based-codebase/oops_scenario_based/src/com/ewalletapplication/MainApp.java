package com.ewalletapplication;
public class MainApp {

    public static void main(String[] args) {

        // Users with optional referral bonus
        User u1 = new User("U101", "Andrew Tate",
                new PersonalWallet(3000, 200));  // referral

        User u2 = new User("U202", "Tristan Tate",
                new BusinessWallet(200000));     // no referral

        u1.getWallet().displayWalletType();
        u2.getWallet().displayWalletType();

        System.out.println("\n--- TRANSFERS ---");

        // Polymorphism — transferTo works differently
        if (u1.getWallet().transferTo(u2, 1000)) {
            u1.addTransaction("Sent to Tristan Tate", -1000);
            u2.addTransaction("Received from Andrew Tate", 1000);
        }

        if (u2.getWallet().transferTo(u1, 120000)) {
            u2.addTransaction("Sent to Andrew Tate", -120000);
            u1.addTransaction("Received from Tristan Tate", 120000);
        }

        System.out.println("\n--- FINAL BALANCES ---");
        u1.getWallet().displayWalletType();
        u2.getWallet().displayWalletType();

        u1.showHistory();
        u2.showHistory();
    }
}
