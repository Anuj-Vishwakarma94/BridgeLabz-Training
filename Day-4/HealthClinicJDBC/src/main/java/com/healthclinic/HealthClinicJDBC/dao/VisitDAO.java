package com.healthclinic.HealthClinicJDBC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.healthclinic.HealthClinicJDBC.config.DatabaseConnection;
import com.healthclinic.HealthClinicJDBC.model.Visit;

public class VisitDAO {

    public boolean addVisit(Visit visit) {

        String sql = "INSERT INTO visit(appointment_id, visit_date, diagnosis) VALUES (?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, visit.getAppointmentId());
            ps.setTimestamp(2, visit.getVisitDate());
            ps.setString(3, visit.getDiagnosis());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return false;
    }

    public List<Visit> getAllVisits() {

        List<Visit> visits = new ArrayList<>();

        String sql = "SELECT * FROM visit";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Visit visit = new Visit(
                        rs.getInt("visit_id"),
                        rs.getInt("appointment_id"),
                        rs.getTimestamp("visit_date"),
                        rs.getString("diagnosis")
                );

                visits.add(visit);
            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return visits;
    }

    public Visit getVisitById(int visitId) {

        String sql = "SELECT * FROM visit WHERE visit_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, visitId);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new Visit(
                            rs.getInt("visit_id"),
                            rs.getInt("appointment_id"),
                            rs.getTimestamp("visit_date"),
                            rs.getString("diagnosis")
                    );
                }

            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return null;
    }

    public boolean updateVisit(Visit visit) {

        String sql = "UPDATE visit SET appointment_id=?, visit_date=?, diagnosis=? WHERE visit_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, visit.getAppointmentId());
            ps.setTimestamp(2, visit.getVisitDate());
            ps.setString(3, visit.getDiagnosis());
            ps.setInt(4, visit.getVisitId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return false;
    }

    public boolean deleteVisit(int visitId) {

        String sql = "DELETE FROM visit WHERE visit_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, visitId);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return false;
    }

    public List<Visit> getVisitsByAppointment(int appointmentId) {

        List<Visit> visits = new ArrayList<>();

        String sql = "SELECT * FROM visit WHERE appointment_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, appointmentId);

            try (ResultSet rs = ps.executeQuery()) {

                while (rs.next()) {

                    visits.add(new Visit(
                            rs.getInt("visit_id"),
                            rs.getInt("appointment_id"),
                            rs.getTimestamp("visit_date"),
                            rs.getString("diagnosis")
                    ));
                }

            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return visits;
    }

    public void viewVisitDetails() {

        String sql =
                "SELECT v.visit_id, " +
                "p.name AS patient_name, " +
                "d.doctor_name, " +
                "v.visit_date, " +
                "v.diagnosis " +
                "FROM visit v " +
                "JOIN appointment a ON v.appointment_id = a.appointment_id " +
                "JOIN patient p ON a.patient_id = p.patient_id " +
                "JOIN doctor d ON a.doctor_id = d.doctor_id";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            System.out.println("\n========== VISIT DETAILS ==========");

            while (rs.next()) {

                System.out.println("Visit ID      : " + rs.getInt("visit_id"));
                System.out.println("Patient Name  : " + rs.getString("patient_name"));
                System.out.println("Doctor Name   : " + rs.getString("doctor_name"));
                System.out.println("Visit Date    : " + rs.getTimestamp("visit_date"));
                System.out.println("Diagnosis     : " + rs.getString("diagnosis"));
                System.out.println("----------------------------------");

            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }
    }
}