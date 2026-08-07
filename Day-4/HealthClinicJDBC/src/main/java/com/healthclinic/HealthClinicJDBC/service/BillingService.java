package com.healthclinic.HealthClinicJDBC.service;

import java.util.List;

import com.healthclinic.HealthClinicJDBC.dao.BillingDAO;
import com.healthclinic.HealthClinicJDBC.model.Billing;

public class BillingService {

    private BillingDAO billingDAO = new BillingDAO();

    public boolean addBill(Billing bill) {

        double total = bill.getConsultationFee()
                     + bill.getMedicineCharge()
                     + bill.getTestCharge();

        bill.setTotalAmount(total);

        return billingDAO.addBill(bill);
    }

    public List<Billing> getAllBills() {
        return billingDAO.getAllBills();
    }

    public Billing getBillById(int billId) {
        return billingDAO.getBillById(billId);
    }

    public boolean updateBill(Billing bill) {

        double total = bill.getConsultationFee()
                     + bill.getMedicineCharge()
                     + bill.getTestCharge();

        bill.setTotalAmount(total);

        return billingDAO.updateBill(bill);
    }

    public boolean deleteBill(int billId) {
        return billingDAO.deleteBill(billId);
    }

    public List<Billing> getBillsByAppointment(int appointmentId) {
        return billingDAO.getBillsByAppointment(appointmentId);
    }

}