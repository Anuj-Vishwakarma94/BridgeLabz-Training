package com.healthclinic.HealthClinicJDBC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.healthclinic.HealthClinicJDBC.config.DatabaseConnection;
import com.healthclinic.HealthClinicJDBC.model.Billing;

public class BillingDAO {

    public boolean addBill(Billing bill) {

        String sql = "INSERT INTO billing(appointment_id, consultation_fee, medicine_charge, test_charge, total_amount, payment_status) VALUES (?, ?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, bill.getAppointmentId());
            ps.setDouble(2, bill.getConsultationFee());
            ps.setDouble(3, bill.getMedicineCharge());
            ps.setDouble(4, bill.getTestCharge());
            ps.setDouble(5, bill.getTotalAmount());
            ps.setString(6, bill.getPaymentStatus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Database Error : " + e.getMessage());
        }

        return false;
    }

    public List<Billing> getAllBills() {

        List<Billing> bills = new ArrayList<>();

        String sql = "SELECT * FROM billing";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Billing bill = new Billing(
                        rs.getInt("bill_id"),
                        rs.getInt("appointment_id"),
                        rs.getDouble("consultation_fee"),
                        rs.getDouble("medicine_charge"),
                        rs.getDouble("test_charge"),
                        rs.getDouble("total_amount"),
                        rs.getString("payment_status")
                );

                bills.add(bill);
            }

        } catch (SQLException e) {
            System.out.println("Database Error : " + e.getMessage());
        }

        return bills;
    }

    public Billing getBillById(int billId) {

        String sql = "SELECT * FROM billing WHERE bill_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, billId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new Billing(
                            rs.getInt("bill_id"),
                            rs.getInt("appointment_id"),
                            rs.getDouble("consultation_fee"),
                            rs.getDouble("medicine_charge"),
                            rs.getDouble("test_charge"),
                            rs.getDouble("total_amount"),
                            rs.getString("payment_status")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Database Error : " + e.getMessage());
        }

        return null;
    }

    public boolean updateBill(Billing bill) {

        String sql = "UPDATE billing SET appointment_id=?, consultation_fee=?, medicine_charge=?, test_charge=?, total_amount=?, payment_status=? WHERE bill_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, bill.getAppointmentId());
            ps.setDouble(2, bill.getConsultationFee());
            ps.setDouble(3, bill.getMedicineCharge());
            ps.setDouble(4, bill.getTestCharge());
            ps.setDouble(5, bill.getTotalAmount());
            ps.setString(6, bill.getPaymentStatus());
            ps.setInt(7, bill.getBillId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Database Error : " + e.getMessage());
        }

        return false;
    }

    public boolean deleteBill(int billId) {

        String sql = "DELETE FROM billing WHERE bill_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, billId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Database Error : " + e.getMessage());
        }

        return false;
    }

    public List<Billing> getBillsByAppointment(int appointmentId) {

        List<Billing> bills = new ArrayList<>();

        String sql = "SELECT * FROM billing WHERE appointment_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, appointmentId);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    bills.add(new Billing(
                            rs.getInt("bill_id"),
                            rs.getInt("appointment_id"),
                            rs.getDouble("consultation_fee"),
                            rs.getDouble("medicine_charge"),
                            rs.getDouble("test_charge"),
                            rs.getDouble("total_amount"),
                            rs.getString("payment_status")
                    ));
                }
            }

        } catch (SQLException e) {
            System.out.println("Database Error : " + e.getMessage());
        }

        return bills;
    }
}