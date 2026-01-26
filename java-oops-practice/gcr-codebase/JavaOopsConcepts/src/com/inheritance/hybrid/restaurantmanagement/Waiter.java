package com.inheritance.hybrid.restaurantmanagement;

public class Waiter extends Person implements Worker {

    private int tableCount;

    // Constructor to initialize waiter details
    public Waiter(String name, int id, int tableCount) {
        super(name, id);
        this.tableCount = tableCount;
    }

    // Implementation of interface method
    @Override
    public void performDuties() {
        System.out.println("Role : Waiter");
        System.out.println("Duties: Serving " + tableCount + " tables");
    }
}
