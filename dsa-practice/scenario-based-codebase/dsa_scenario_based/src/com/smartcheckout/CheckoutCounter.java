package com.smartcheckout;

import java.util.*;

public class CheckoutCounter {

    Queue<Customer> queue = new LinkedList<>();
    HashMap<String, Item> storeItems = new HashMap<>();

    public CheckoutCounter() {
        storeItems.put("Rice", new Item("Rice", 50, 20));
        storeItems.put("Milk", new Item("Milk", 30, 15));
        storeItems.put("Bread", new Item("Bread", 25, 10));
    }

    public void addCustomer(Customer c) {
        queue.add(c);
        System.out.println("Customer added to queue");
    }

    public void processCustomer() {
        if (queue.isEmpty()) {
            System.out.println("No customers in queue");
            return;
        }

        Customer c = queue.poll();
        int total = 0;

        for (String itemName : c.cart.keySet()) {
            Item item = storeItems.get(itemName);
            int qty = c.cart.get(itemName);

            if (item != null && item.stock >= qty) {
                total += item.price * qty;
                item.stock -= qty;
            } else {
                System.out.println(itemName + " out of stock or not available");
            }
        }

        System.out.println("Customer: " + c.name);
        System.out.println("Total Bill: ₹" + total);
    }

    public void showStock() {
        for (Item item : storeItems.values()) {
            System.out.println(item.name + " | Price: " + item.price + " | Stock: " + item.stock);
        }
    }
}
