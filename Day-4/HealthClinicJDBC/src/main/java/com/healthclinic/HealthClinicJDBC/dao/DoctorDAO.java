package com.healthclinic.HealthClinicJDBC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.healthclinic.HealthClinicJDBC.config.DatabaseConnection;
import com.healthclinic.HealthClinicJDBC.model.Doctor;

public class DoctorDAO {

    public boolean addDoctor(Doctor doctor) {

        String sql =
                "INSERT INTO doctor(doctor_name, specialization, phone, department_id) VALUES (?, ?, ?, ?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, doctor.getDoctorName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getPhone());
            ps.setInt(4, doctor.getDepartmentId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public List<Doctor> getAllDoctors() {

        List<Doctor> doctors = new ArrayList<>();

        String sql = "SELECT * FROM doctor";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Doctor doctor = new Doctor(
                        rs.getInt("doctor_id"),
                        rs.getString("doctor_name"),
                        rs.getString("specialization"),
                        rs.getString("phone"),
                        rs.getInt("department_id")
                );

                doctors.add(doctor);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return doctors;
    }

    public Doctor getDoctorById(int id) {

        String sql =
                "SELECT * FROM doctor WHERE doctor_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {

                    return new Doctor(
                            rs.getInt("doctor_id"),
                            rs.getString("doctor_name"),
                            rs.getString("specialization"),
                            rs.getString("phone"),
                            rs.getInt("department_id")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public boolean updateDoctor(Doctor doctor) {

        String sql =
                "UPDATE doctor SET doctor_name=?, specialization=?, phone=?, department_id=? WHERE doctor_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, doctor.getDoctorName());
            ps.setString(2, doctor.getSpecialization());
            ps.setString(3, doctor.getPhone());
            ps.setInt(4, doctor.getDepartmentId());
            ps.setInt(5, doctor.getDoctorId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean deleteDoctor(int id) {

        String sql =
                "DELETE FROM doctor WHERE doctor_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }
}