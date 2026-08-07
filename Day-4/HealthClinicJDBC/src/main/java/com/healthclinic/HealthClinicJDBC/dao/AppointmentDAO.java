package com.healthclinic.HealthClinicJDBC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.healthclinic.HealthClinicJDBC.config.DatabaseConnection;
import com.healthclinic.HealthClinicJDBC.model.Appointment;

public class AppointmentDAO {

    public boolean addAppointment(Appointment appointment) {

        String sql = "INSERT INTO appointment(patient_id, doctor_id, appointment_date, appointment_time, status) VALUES (?, ?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, appointment.getPatientId());
            ps.setInt(2, appointment.getDoctorId());
            ps.setDate(3, appointment.getAppointmentDate());
            ps.setTime(4, appointment.getAppointmentTime());
            ps.setString(5, appointment.getStatus());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return false;
    }

    public List<Appointment> getAllAppointments() {

        List<Appointment> appointments = new ArrayList<>();

        String sql = "SELECT * FROM appointment";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Appointment appointment = new Appointment(
                        rs.getInt("appointment_id"),
                        rs.getInt("patient_id"),
                        rs.getInt("doctor_id"),
                        rs.getDate("appointment_date"),
                        rs.getTime("appointment_time"),
                        rs.getString("status")
                );

                appointments.add(appointment);
            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return appointments;
    }

    public boolean updateStatus(int appointmentId, String status) {

        String sql = "UPDATE appointment SET status=? WHERE appointment_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, status);
            ps.setInt(2, appointmentId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return false;
    }

    public boolean deleteAppointment(int id) {

        String sql = "DELETE FROM appointment WHERE appointment_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return false;
    }
}