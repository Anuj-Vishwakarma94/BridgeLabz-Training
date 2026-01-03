package com.linkedlist.singlylinkedlist.inventorymanagementsystem;

public class InventoryManagementSystem {
    public static void main(String[] args) {
        InventoryLinkedList inventory = new InventoryLinkedList();

        inventory.addAtEnd(101, "Asus Laptop", 5, 55000);
        inventory.addAtEnd(102, "Mouse", 20, 2500);
        inventory.addAtBeginning(103, "Console", 10, 50000);
        inventory.addAtPosition(2, 104, "Controller", 7, 1200);

        System.out.println("\n--- Inventory ---");
        inventory.displayAll();

        System.out.println("\n--- Search by ID ---");
        inventory.searchById(102);

        System.out.println("\n--- Update Quantity ---");
        inventory.updateQuantity(101, 8);

        System.out.println("\n--- Total Inventory Value ---");
        inventory.totalInventoryValue();

        System.out.println("\n--- Sort by Name (Ascending) ---");
        inventory.sortByName(true);
        inventory.displayAll();

        System.out.println("\n--- Sort by Price (Descending) ---");
        inventory.sortByPrice(false);
        inventory.displayAll();
    }
}
