package com.foodloop;

import java.util.Scanner;

public class FoodLoopTest {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        FoodItem f1 = new VegItem("Paneer Pizza", 400, 5);
        FoodItem f2 = new NonVegItem("Chicken Burger", 300, 5);
        FoodItem f3 = new VegItem("Pasta", 250, 5);

        Order order = new Order();
        int choice;

        do {
            System.out.println("\n--- MENU ---");
            System.out.println("1. Paneer Pizza (Veg) ₹400");
            System.out.println("2. Chicken Burger (Non-Veg) ₹300");
            System.out.println("3. Pasta (Veg) ₹250");
            System.out.println("4. Place Order");
            System.out.print("Choose option: ");

            choice = sc.nextInt();

            switch (choice) {
                case 1: order.addItem(f1); break;
                case 2: order.addItem(f2); break;
                case 3: order.addItem(f3); break;
                case 4: order.placeOrder(); break;
                default: System.out.println("Invalid choice");
            }

        } while (choice != 4);

        sc.close();
    }
}
