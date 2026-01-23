package com.ecommerceproductinventory;

public class ProductNode {

    int key;           
    String name;        
    double price;       

    ProductNode left;
    ProductNode right;

    ProductNode(int key, String name, double price) {
        this.key = key;
        this.name = name;
        this.price = price;
        left = null;
        right = null;
    }
}
