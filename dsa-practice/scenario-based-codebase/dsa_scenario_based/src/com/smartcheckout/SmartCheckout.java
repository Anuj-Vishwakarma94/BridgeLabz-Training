package com.smartcheckout;

import java.util.Scanner;

public class SmartCheckout {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        CheckoutCounter counter = new CheckoutCounter();

        while (true) {
            System.out.println("\n1. Add Customer");
            System.out.println("2. Process Customer");
            System.out.println("3. Show Stock");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter customer name: ");
                    String name = sc.next();

                    Customer c = new Customer(name);

                    while (true) {
                        System.out.print("Enter item name (or exit): ");
                        String item = sc.next();
                        if (item.equalsIgnoreCase("exit")) break;

                        System.out.print("Enter quantity: ");
                        int qty = sc.nextInt();
                        c.addItem(item, qty);
                    }

                    counter.addCustomer(c);
                    break;

                case 2:
                    counter.processCustomer();
                    break;

                case 3:
                    counter.showStock();
                    break;

                case 4:
                    System.out.println("Thank you for using SmartCheckout");
                    return;

                default:
                    System.out.println("Invalid choice");
            }
        }
    }
}
