package com.artify;

import java.util.Scanner;

public class ArtifyTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your name: ");
        String name = sc.nextLine();

        System.out.print("Enter wallet balance: ");
        double balance = sc.nextDouble();

        User user = new User(name, balance);

        System.out.println("\nAvailable Artworks:");
        System.out.println("1. Cyber Dreams  | Artist: Alex   | ₹1500 | Digital");
        System.out.println("2. Vintage Sketch | Artist: Maria | ₹2500 | Print");
        System.out.println("3. Neon City     | Artist: John   | ₹2000 | Digital");

        System.out.print("\nChoose artwork (1-3): ");
        int choice = sc.nextInt();

        Artwork artwork = null;

        switch (choice) {
            case 1:
                artwork = new DigitalArt(
                        "Cyber Dreams",
                        "Alex",
                        1500,
                        "Standard",
                        true
                );
                break;

            case 2:
                artwork = new PrintArt(
                        "Vintage Sketch",
                        "Maria",
                        2500,
                        "Commercial",
                        false
                );
                break;

            case 3:
                artwork = new DigitalArt(
                        "Neon City",
                        "John",
                        2000,
                        "Standard",
                        true
                );
                break;

            default:
                System.out.println("Invalid choice");
                System.exit(0);
        }
        artwork.purchase(user);

        System.out.println("\nRemaining Wallet Balance: ₹" + user.getWalletBalance());
        sc.close();
    }
}
