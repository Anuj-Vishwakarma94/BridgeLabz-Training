package com.inheritance.hybrid.restaurantmanagement;

public class RestaurantManagementSystem {

    public static void main(String[] args) {

        // Hybrid inheritance demonstration
        Worker worker1 = new Chef("Ramesh", 101, "Italian");
        Worker worker2 = new Waiter("Suresh", 102, 8);

        worker1.performDuties();
        System.out.println("---------------------");

        worker2.performDuties();
    }
}
