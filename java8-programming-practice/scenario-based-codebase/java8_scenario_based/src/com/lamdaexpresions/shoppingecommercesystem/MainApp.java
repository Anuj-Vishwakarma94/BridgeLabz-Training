package com.lamdaexpresions.shoppingecommercesystem;

import java.util.*;

public class MainApp {

    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Product(1, "Mobile", 12000));
        products.add(new Product(2, "Headphones", 800));
        products.add(new Product(3, "Charger", 400));
        products.add(new Product(4, "Mouse", 600));

        // 1. Apply 10% discount
        DiscountCalculator dc = price -> price * 0.90;
        System.out.println("Discounted Price: " + dc.apply(12000));

        // 2. Sort by price
        ProductSort.sortByPrice(products);
        System.out.println("\nSorted by Price:");
        products.forEach(System.out::println);

        // 3. Free delivery check
        DeliveryCheck fd = amount -> amount > 500;
        System.out.println("\nFree Delivery: " + fd.isFree(800));

        // 4. Final bill amount
        double total = products.stream()
                .mapToDouble(p -> p.price)
                .sum();
        System.out.println("\nFinal Bill Amount: " + total);

        // 5. Print product names
        System.out.println("\nProduct Names:");
        products.forEach(p -> System.out.println(p.name));
    }
}
