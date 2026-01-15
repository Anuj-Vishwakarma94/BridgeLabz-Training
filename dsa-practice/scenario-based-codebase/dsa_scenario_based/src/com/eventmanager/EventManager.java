package com.eventmanager;
import java.util.Scanner;

public class EventManager {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("=================================");
        System.out.println(" EventManager Ticket Optimizer!! ");
        System.out.println("=================================");

        System.out.print("Enter number of tickets: ");
        int n = sc.nextInt();

        Ticket[] tickets = new Ticket[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter ticket price: ");
            double price = sc.nextDouble();
            tickets[i] = new Ticket(price);
        }

        System.out.println("\nBefore Sorting:");
        QuickSortUtil.display(tickets);

        QuickSortUtil.quickSort(tickets, 0, n - 1);

        System.out.println("\nAfter Sorting (Cheapest → Most Expensive):");
        QuickSortUtil.display(tickets);

        sc.close();
    }
}
