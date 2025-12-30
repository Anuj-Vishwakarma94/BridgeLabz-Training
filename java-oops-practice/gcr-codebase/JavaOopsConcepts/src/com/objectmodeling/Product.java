package com.objectmodeling;

public class Product {

    String productname;
    double price;

    Product(String productname, double price) {
        this.productname = productname;
        this.price = price;
    }

    void showProduct() {
        System.out.println(productname + " - Rs " + price);
    }
}
