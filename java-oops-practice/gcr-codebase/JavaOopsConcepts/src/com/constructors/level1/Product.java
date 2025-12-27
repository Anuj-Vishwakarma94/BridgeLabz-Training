package com.constructors.level1;

public class Product {
	
    String productName;
    double price;

    static int totalProducts = 0;

    Product(String name, double price) {
        this.productName = name;
        this.price = price;

        totalProducts++;
    }

    // Instance method
    void displayProductDetails() {
        System.out.println("Product Name: " + productName);
        System.out.println("Price: " + price);
    }

    static void displayTotalProducts() {
        System.out.println("Total Products Created: " + totalProducts);
    }

    public static void main(String[] args) {
        Product p1 = new Product("Laptop", 55000);
        Product p2 = new Product("Headphones", 2500);

        p1.displayProductDetails();
        System.out.println();
        p2.displayProductDetails();

        System.out.println();
        Product.displayTotalProducts();
    }
}