package com.inheritance.multilevel.onlineretail;

public class OnlineRetailOrderManagement {

    public static void main(String[] args) {

        // Multilevel inheritance demonstration
        Order order1 = new Order(101, "2025-01-10");
        Order order2 = new ShippedOrder(102, "2025-01-11", "TRK12345");
        Order order3 = new DeliveredOrder(103, "2025-01-12", "TRK67890", "2025-01-15");

        System.out.println(order1.getOrderStatus());
        System.out.println(order2.getOrderStatus());
        System.out.println(order3.getOrderStatus());
    }
}
