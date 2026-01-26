package com.encapsulation.onlinefooddelivery;

import java.util.List;
import java.util.ArrayList;

public class OnlineFoodDeliverySystem {
    public static void main(String[] args) {

        List<FoodItem> order = new ArrayList<>();

        order.add(new VegItem("Paneer Butter Masala", 250, 2));
        order.add(new NonVegItem("Chicken Biryani", 300, 1));

        OrderProcessor.processOrder(order);
    }
}
