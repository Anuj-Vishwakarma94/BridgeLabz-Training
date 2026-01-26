package com.payxpress;
public abstract class Bill {
    protected String type;
    protected double amount;
    protected String dueDate;
    private boolean paid;

    public Bill(String type, double amount, String dueDate) {
        this.type = type;
        this.amount = amount;
        this.dueDate = dueDate;
        this.paid = false;
    }

    protected double totalWithLateFee(int daysLate, double penalty) {
        return amount + (daysLate * penalty);
    }

    protected void markPaid() {
        paid = true;
    }

    public boolean isPaid() {
        return paid;
    }

    public String getType() {
        return type;
    }
}
