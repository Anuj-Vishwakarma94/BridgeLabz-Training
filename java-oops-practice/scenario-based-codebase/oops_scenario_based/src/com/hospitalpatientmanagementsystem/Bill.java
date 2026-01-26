package com.hospitalpatientmanagementsystem;
public class Bill implements Payable {

    private Patient patient;
    private double baseAmount;
    private double taxRate = 0.18;
    private double discount = 0;

    public Bill(Patient patient, double baseAmount) {
        this.patient = patient;
        this.baseAmount = baseAmount;

        // Operator logic
        if (patient.isEmergency) {
            discount = -(baseAmount * 0.05);   // 5% extra for emergency
        } else {
            discount = baseAmount * 0.10;      // 10% discount
        }
    }

    @Override
    public double calculatePayment() {
        double tax = baseAmount * taxRate;
        return baseAmount + tax - discount;
    }

    public void printBill() {
        System.out.println("\n--- BILL SUMMARY ---");
        System.out.println(patient.getSummary());
        System.out.println("Base Amount: ₹" + baseAmount);
        System.out.println("Discount(+/-): ₹" + discount);
        System.out.println("Tax (18%): ₹" + (baseAmount * taxRate));
        System.out.println("Total Payable: ₹" + calculatePayment());
        System.out.println("--------------------\n");
    }
}
