package com.objectmodeling;

public class Customer2 {
	String customername;

    Customer2(String customername) {
        this.customername = customername;
    }

    void placeOrder(Order order) {
        System.out.println(customername + " placed order " + order.orderid);
    }
}
