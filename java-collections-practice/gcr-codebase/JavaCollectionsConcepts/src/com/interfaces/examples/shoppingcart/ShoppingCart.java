package com.interfaces.examples.shoppingcart;

import java.util.*;

public class ShoppingCart {

    private final Map<String, Double> productPrices = new HashMap<>();
    private final Map<String, Double> orderedCart = new LinkedHashMap<>();
    private final TreeMap<Double, List<String>> sortedByPrice = new TreeMap<>();

    public void addItem(String product, double price) {

        if (productPrices.containsKey(product)) {
            double oldPrice = productPrices.get(product);
            removeFromSortedMap(product, oldPrice);
        }

        productPrices.put(product, price);
        orderedCart.put(product, price);
        sortedByPrice
                .computeIfAbsent(price, k -> new ArrayList<>())
                .add(product);
    }

    private void removeFromSortedMap(String product, double price) {
        List<String> list = sortedByPrice.get(price);
        if (list != null) {
            list.remove(product);
            if (list.isEmpty()) {
                sortedByPrice.remove(price);
            }
        }
    }

    public double getTotal() {
        double total = 0;
        for (double price : orderedCart.values()) {
            total += price;
        }
        return total;
    }

    public void displayCart() {
        System.out.println("\n=== Shopping Cart Summary ===\n");

        System.out.println("HashMap (unordered, fast lookup):");
        productPrices.forEach((item, price) ->
                System.out.printf("  %-15s : $%.2f%n", item, price));

        System.out.println();

        System.out.println("LinkedHashMap (order of addition):");
        orderedCart.forEach((item, price) ->
                System.out.printf("  %-15s : $%.2f%n", item, price));

        System.out.println();

        System.out.println("TreeMap (sorted by price):");
        for (Map.Entry<Double, List<String>> entry : sortedByPrice.entrySet()) {
            for (String item : entry.getValue()) {
                System.out.printf("  %-15s : $%.2f%n", item, entry.getKey());
            }
        }

        System.out.println("-------------------------------");
        System.out.printf("Total Amount     : $%.2f%n", getTotal());
        System.out.println("================================");
    }

    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        cart.addItem("Notebook", 45.50);
        cart.addItem("Pen", 12.00);
        cart.addItem("Water Bottle", 250.00);
        cart.addItem("Eraser", 8.00);
        cart.addItem("Highlighter", 25.00);
        cart.addItem("Notebook", 45.50);

        cart.displayCart();
    }
}
