package com.ecommerceproductinventory;

import java.util.Scanner;

public class ECommerceProductInventory {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Inventory inventory = new Inventory();
        int choice;

        do {
            System.out.println("\n--- E-Commerce Product Inventory ---");
            System.out.println("1. Add Product");
            System.out.println("2. Search Product");
            System.out.println("3. Update Price");
            System.out.println("4. Display Products");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter SKU: ");
                    int key = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter product name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter price: ");
                    double price = sc.nextDouble();

                    inventory.root = inventory.insert(inventory.root, key, name, price);
                    System.out.println("Product Added");
                    break;

                case 2:
                    System.out.print("Enter SKU to search: ");
                    int searchKey = sc.nextInt();

                    ProductNode result = inventory.search(inventory.root, searchKey);
                    if (result != null) {
                        System.out.println(result.key + " | " + result.name + " | ₹" + result.price);
                    } else {
                        System.out.println("Product Not Found");
                    }
                    break;

                case 3:
                    System.out.print("Enter SKU: ");
                    int updateKey = sc.nextInt();

                    System.out.print("Enter new price: ");
                    double newPrice = sc.nextDouble();

                    if (inventory.updatePrice(updateKey, newPrice)) {
                        System.out.println("Price Updated");
                    } else {
                        System.out.println("SKU Not Found");
                    }
                    break;

                case 4:
                    System.out.println("Product List (Sorted by SKU):");
                    inventory.inorder(inventory.root);
                    break;

                case 5:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid Choice");
            }

        } while (choice != 5);
        sc.close();
    }
}
