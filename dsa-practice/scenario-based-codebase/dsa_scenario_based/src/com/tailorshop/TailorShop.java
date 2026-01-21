package com.tailorshop;
import java.util.Scanner;

public class TailorShop {

    static void insertionSort(Order[] orders) {
        int n = orders.length;

        for (int i = 1; i < n; i++) {
            Order key = orders[i];
            int j = i - 1;

            while (j >= 0 && orders[j].deadlineDays > key.deadlineDays) {
                orders[j + 1] = orders[j];
                j--;
            }
            orders[j + 1] = key;
        }
    }

    static void display(Order[] orders) {
        for (Order o : orders)
            System.out.println(o.customerName + " → Delivery in " + o.deadlineDays + " days");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of orders: ");
        int n = sc.nextInt();
        sc.nextLine();

        Order[] orders = new Order[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Customer name: ");
            String name = sc.nextLine();
            System.out.print("Delivery deadline (days): ");
            int days = sc.nextInt();
            sc.nextLine();
            orders[i] = new Order(name, days);
        }

        insertionSort(orders);

        System.out.println("\nSorted Orders by Delivery Deadline:");
        display(orders);

        sc.close();
    }
}
