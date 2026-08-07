package com.healthclinic.HealthClinicJDBC.dao;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.healthclinic.HealthClinicJDBC.config.DatabaseConnection;
import com.healthclinic.HealthClinicJDBC.model.Patient;

public class PatientDAO {

    public boolean addPatient(Patient patient) {

        String sql = "INSERT INTO patient(name, age, gender, phone) VALUES (?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return false;
    }

    public List<Patient> getAllPatients() {

        List<Patient> patients = new ArrayList<>();

        String sql = "SELECT * FROM patient";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Patient patient = new Patient(
                        rs.getInt("patient_id"),
                        rs.getString("name"),
                        rs.getInt("age"),
                        rs.getString("gender"),
                        rs.getString("phone")
                );

                patients.add(patient);
            }

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return patients;
    }

    public Patient getPatientById(int id) {

        String sql = "{CALL GetPatientById(?)}";

        try (Connection con = DatabaseConnection.getConnection();
             CallableStatement cs = con.prepareCall(sql)) {

            cs.setInt(1, id);

            try (ResultSet rs = cs.executeQuery()) {

                if (rs.next()) {

                    return new Patient(
                            rs.getInt("patient_id"),
                            rs.getString("name"),
                            rs.getInt("age"),
                            rs.getString("gender"),
                            rs.getString("phone")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println("Stored Procedure Error: " + e.getMessage());
        }

        return null;
    }

    public boolean updatePatient(Patient patient) {

        String sql = "UPDATE patient SET name=?, age=?, gender=?, phone=? WHERE patient_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, patient.getName());
            ps.setInt(2, patient.getAge());
            ps.setString(3, patient.getGender());
            ps.setString(4, patient.getPhone());
            ps.setInt(5, patient.getPatientId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println("Database Error: " + e.getMessage());
        }

        return false;
    }

    public boolean deletePatient(int id) {

        String sql = "DELETE FROM patient WHERE patient_id=?";

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