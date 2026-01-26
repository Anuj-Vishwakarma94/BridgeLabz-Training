package com.encapsulation.onlinefooddelivery;

public class NonVegItem extends FoodItem{
    private static final double NON_VEG_CHARGE = 50;

    public NonVegItem(String itemName, double price, int quantity) {
        super(itemName, price, quantity);
    }

    @Override
    public double calculateTotalPrice() {
        return (getPrice() * getQuantity()) + NON_VEG_CHARGE;
    }

}
