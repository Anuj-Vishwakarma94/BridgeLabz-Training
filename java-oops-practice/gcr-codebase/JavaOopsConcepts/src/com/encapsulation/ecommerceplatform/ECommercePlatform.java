package com.encapsulation.ecommerceplatform;

import java.util.ArrayList;
import java.util.List;

public class ECommercePlatform {
    public static void main(String[] args) {

        List<Product> products = new ArrayList<>();

        products.add(new Electronics(1, "Laptop", 60000));
        products.add(new Clothing(2, "T-Shirt", 1500));
        products.add(new Groceries(3, "Rice Bag", 1200));

        calculateFinalPrice(products);
    }

    // Polymorphic method
    public static void calculateFinalPrice(List<Product> products) {

        for (Product product : products) {

            double price = product.getPrice();
            double discount = product.calculateDiscount();
            double tax = 0;

            if (product instanceof Taxable) {
                tax = ((Taxable) product).calculateTax();
            }

            double finalPrice = price + tax - discount;

            product.displayProduct();

            if (product instanceof Taxable) {
                System.out.println("Tax: " +
                        ((Taxable) product).getTaxDetails());
            } else {
                System.out.println("Tax: Not Applicable");
            }

            System.out.println("Discount: " + discount);
            System.out.println("Final Price: " + finalPrice);
            System.out.println("-------------------------");
        }
    }
}
