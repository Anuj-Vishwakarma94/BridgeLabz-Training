package com.callcentre;
import java.util.*;
public class CallCentre {
	public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Manager manager = new Manager();
        int time = 0;

        while (true) {

            System.out.println("\n1. Add Customer Call");
            System.out.println("2. Handle Next Call");
            System.out.println("3. Show Call Count");
            System.out.println("4. Exit");
            System.out.print("Choose option: ");

            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter customer name: ");
                String name = sc.next();

                System.out.print("Is VIP? (true/false): ");
                boolean isVIP = sc.nextBoolean();

                manager.addCustomer(new Customer(name, isVIP, time++));
                System.out.println("Customer added");

            } else if (choice == 2) {
                manager.handlecalls();

            } else if (choice == 3) {
                manager.showCallCounts();

            } else if (choice == 4) {
                break;
            }
        }

        sc.close();
    }
}

