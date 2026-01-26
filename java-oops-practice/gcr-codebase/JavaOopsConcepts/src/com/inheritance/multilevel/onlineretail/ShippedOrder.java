package com.inheritance.multilevel.onlineretail;

public class ShippedOrder extends Order {

    protected String trackingNumber;

    // Constructor to initialize shipped order details
    public ShippedOrder(int orderId, String orderDate, String trackingNumber) {
        super(orderId, orderDate);
        this.trackingNumber = trackingNumber;
    }

    // Overridden method to reflect shipped status
    @Override
    public String getOrderStatus() {
        return "Order Shipped (Tracking No: " + trackingNumber + ")";
    }
}
