package com.generics.smartwarehousemanagementsystem;

import java.util.*;

public class SmartWarehouseSystem {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 1; i <= n; i++) {

            System.out.println("\nItem " + i);
            System.out.print("Item Name: ");
            String name = sc.nextLine();

            System.out.print("Price: ");
            double price = sc.nextDouble();
            sc.nextLine();

            System.out.println("Select Category:");
            System.out.println("1. Electronics");
            System.out.println("2. Groceries");
            System.out.println("3. Furniture");
            int choice = sc.nextInt();
            sc.nextLine();

            if (choice == 1) {
                electronicsStorage.addItem(new Electronics(name, price));
            } else if (choice == 2) {
                groceriesStorage.addItem(new Groceries(name, price));
            } else if (choice == 3) {
                furnitureStorage.addItem(new Furniture(name, price));
            } else {
                System.out.println("Invalid category");
                i--;
            }
        }

        System.out.println("\n---- Electronics ----");
        WarehouseUtil.displayItems(electronicsStorage.getItems());

        System.out.println("\n---- Groceries ----");
        WarehouseUtil.displayItems(groceriesStorage.getItems());

        System.out.println("\n---- Furniture ----");
        WarehouseUtil.displayItems(furnitureStorage.getItems());

        sc.close();
    }
}
