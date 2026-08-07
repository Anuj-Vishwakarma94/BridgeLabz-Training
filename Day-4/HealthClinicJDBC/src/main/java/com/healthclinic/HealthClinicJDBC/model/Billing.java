package com.healthclinic.HealthClinicJDBC.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Billing {

    private int billId;

    private int appointmentId;

    private double consultationFee;

    private double medicineCharge;

    private double testCharge;

    private double totalAmount;

    private String paymentStatus;

    public Billing(int appointmentId,
                   double consultationFee,
                   double medicineCharge,
                   double testCharge,
                   double totalAmount,
                   String paymentStatus) {

        this.appointmentId = appointmentId;
        this.consultationFee = consultationFee;
        this.medicineCharge = medicineCharge;
        this.testCharge = testCharge;
        this.totalAmount = totalAmount;
        this.paymentStatus = paymentStatus;

    }

}