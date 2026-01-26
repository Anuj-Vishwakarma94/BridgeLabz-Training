package com.payxpress;
public class InternetBill extends Bill implements IPayable {

    public InternetBill(double amount, String dueDate) {
        super("Internet", amount, dueDate);
    }

    public void pay(int daysLate) {
        if (!isPaid()) {
            double total = totalWithLateFee(daysLate, 15);
            System.out.println("Internet Bill Paid: " + total);
            markPaid();
        } else {
            System.out.println("Bill already paid");
        }
    }

    public void sendReminder() {
        System.out.println("Internet Bill due on " + dueDate);
    }
}
