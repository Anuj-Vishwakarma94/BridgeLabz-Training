package com.payxpress;
public class ElectricityBill extends Bill implements IPayable {

    public ElectricityBill(double amount, String dueDate) {
        super("Electricity", amount, dueDate);
    }

    public void pay(int daysLate) {
        if (!isPaid()) {
            double total = totalWithLateFee(daysLate, 10);
            System.out.println("Electricity Bill Paid: " + total);
            markPaid();
        } else {
            System.out.println("Bill already paid");
        }
    }

    public void sendReminder() {
        System.out.println("Electricity Bill due on " + dueDate);
    }
}
