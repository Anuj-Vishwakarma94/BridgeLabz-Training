package com.encapsulation.onlinefooddelivery;

import java.util.List;

public class OrderProcessor {
	public static void processOrder(List<FoodItem> items) {

        double grandTotal = 0;

        for (FoodItem item : items) {

            item.getItemDetails();

            double total = item.calculateTotalPrice();
            double discount = 0;

            if (item instanceof Discountable) {
                Discountable discountItem = (Discountable) item;
                discount = discountItem.applyDiscount(total);
                System.out.println("Discount: " +
                        discountItem.getDiscountDetails());
            } else {
                System.out.println("Discount: Not Applicable");
            }

            double finalPrice = total - discount;
            System.out.println("Final Price: " + finalPrice);
            System.out.println("-------------------------");

            grandTotal += finalPrice;
        }

        System.out.println("Grand Total Payable: " + grandTotal);
    }
}
