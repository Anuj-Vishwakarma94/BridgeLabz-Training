package com.foodloop;
import java.util.ArrayList;

class Order implements IOrderable {

    private ArrayList<FoodItem> items = new ArrayList<>();
    private double total;

    public void addItem(FoodItem item) {
        if (item.isAvailable()) {
            items.add(item);
            total += item.getPrice();
            item.reduceStock();
            System.out.println(item.getName() + " added");
        } else {
            System.out.println(item.getName() + " out of stock");
        }
    }

    private double applyDiscount() {
        if (total >= 1000)
            return total * 0.20;
        else if (total >= 500)
            return total * 0.10;
        else
            return 0;
    }

    public void placeOrder() {
        double discount = applyDiscount();
        System.out.println("Total: ₹" + total);
        System.out.println("Discount: ₹" + discount);
        System.out.println("Payable: ₹" + (total - discount));
    }

    public void cancelOrder() {
        System.out.println("Order Cancelled");
    }
}
