package com.bookbazzar;

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // ---- EBOOKS ----
        Book eb1 = new EBook("Learn Java in 30 Days", "James Gosling", 400);
        Book eb2 = new EBook("Python for AI", "Andrew Ng", 650);

        // ---- PRINTED BOOKS ----
        Book pb1 = new PrintedBook("Data Structures & Algorithms", "Robert Lafore", 900, 8);
        Book pb2 = new PrintedBook("Operating System Concepts", "Silberschatz", 1100, 5);

        System.out.print("Enter your name: ");
        String user = sc.nextLine();

        Order order = new Order(user);

        System.out.println("\nSelect Book Type:");
        System.out.println("1. EBook");
        System.out.println("2. Printed Book");
        System.out.print("Enter choice: ");
        int typeChoice = sc.nextInt();

        List<Book> store;

        if (typeChoice == 1) {

            store = Arrays.asList(eb1, eb2);

            System.out.println("\nAvailable EBooks:");
            for (int i = 0; i < store.size(); i++) {
                Book b = store.get(i);
                System.out.println((i+1) + ". " + b.getTitle() +
                                   " | Price: " + b.getPrice());
            }

            System.out.print("\nHow many EBooks do you want to order? ");
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {

                System.out.print("\nEnter ebook number: ");
                int choice = sc.nextInt();

                Book selected = store.get(choice - 1);
                order.addBook(selected, 1);
            }

        } else {

            store = Arrays.asList(pb1, pb2);

            System.out.println("\nAvailable Printed Books:");
            for (int i = 0; i < store.size(); i++) {
                Book b = store.get(i);
                System.out.println((i+1) + ". " + b.getTitle() +
                                   " | Price: " + b.getPrice() +
                                   " | Stock: " + b.getStock());
            }

            System.out.print("\nHow many Printed Books do you want to order? ");
            int n = sc.nextInt();

            for (int i = 0; i < n; i++) {

                System.out.print("\nEnter printed book number: ");
                int choice = sc.nextInt();

                System.out.print("Enter quantity: ");
                int qty = sc.nextInt();

                Book selected = store.get(choice - 1);

                order.addBook(selected, qty);
            }
        }

        order.showSummary();

        System.out.println("\nTotal Cost After Discount = " + order.getTotalCost());

        order.confirmPayment();

        sc.close();
    }
}
