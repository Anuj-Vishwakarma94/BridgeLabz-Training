package com.objectmodeling;
import java.util.ArrayList;

class Order {

    int orderid;
    ArrayList<Product> productlist = new ArrayList<>();

    Order(int orderid) {
        this.orderid = orderid;
    }

    void addProduct(Product product) {
        productlist.add(product);
    }

    void showOrderDetails() {
        System.out.println("Order ID: " + orderid);
        System.out.println("Products:");
        for (Product product : productlist) {
            product.showProduct();
        }
        System.out.println();
    }
}