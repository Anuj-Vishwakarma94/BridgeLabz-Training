package com.swiftcart;
import java.util.ArrayList;
import java.util.List;

public class Cart implements Checkout {

    private List<Product> products;
    private double totalPrice;

    // Constructor without items
    public Cart() {
        this.products = new ArrayList<>();
    }

    // Constructor with pre-selected items
    public Cart(List<Product> products) {
        this.products = products;
        updateTotal();
    }

    public void addProduct(Product product) {
        products.add(product);
        updateTotal();
    }

    public void removeProduct(Product product) {
        products.remove(product);
        updateTotal();
    }

    // ONLY Cart can update total — Encapsulation
    private void updateTotal() {
        totalPrice = 0;
        for (Product p : products) {
            totalPrice += p.applyDiscount();  // polymorphism
        }
        
    }
    public void showCart() {
        System.out.println("\nItems in Cart:");
        for (Product p : products) {
            System.out.println(p.getName() + 
                               " | Qty: " + p.getQuantity() + 
                               " | Category: " + p.getCategory());
        }
    }


    @Override
    public double generateBill() {
        return totalPrice;
    }

    @Override
    public void applyDiscount(double couponAmount) {
        totalPrice = totalPrice - couponAmount; // total - coupon
    }

    public double getTotalPrice() {
        return totalPrice;
    }
}
