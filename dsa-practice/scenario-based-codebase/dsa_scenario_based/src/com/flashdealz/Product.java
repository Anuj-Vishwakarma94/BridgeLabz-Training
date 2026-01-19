package com.flashdealz;
public class Product {

    private String name;
    private int discount; // discount percentage

    public Product(String name, int discount) {
        this.name = name;
        this.discount = discount;
    }

    public String getName() {
        return name;
    }

    public int getDiscount() {
        return discount;
    }
}
