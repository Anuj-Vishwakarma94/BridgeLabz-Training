package com.payxpress;

public class WaterBill extends Bill implements IPayable {

    public WaterBill(double amount, String dueDate) {
        super("Water", amount, dueDate);
    }

    public void pay(int daysLate) {
        if (!isPaid()) {
            double total = totalWithLateFee(daysLate, 5);
            System.out.println("Water Bill Paid: " + total);
            markPaid();
        } else {
            System.out.println("Bill already paid");
        }
    }

    public void sendReminder() {
        System.out.println("Water Bill due on " + dueDate);
    }
}
