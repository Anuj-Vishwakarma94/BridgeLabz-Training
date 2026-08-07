package com.healthclinic.HealthClinicJDBC.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.healthclinic.HealthClinicJDBC.config.DatabaseConnection;
import com.healthclinic.HealthClinicJDBC.model.Department;

public class DepartmentDAO {

    public boolean addDepartment(Department department) {

        String sql =
                "INSERT INTO department(department_name) VALUES (?)";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, department.getDepartmentName());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public List<Department> getAllDepartments() {

        List<Department> departments = new ArrayList<>();

        String sql = "SELECT * FROM department";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {

                Department department = new Department(
                        rs.getInt("department_id"),
                        rs.getString("department_name")
                );

                departments.add(department);
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return departments;
    }

    public Department getDepartmentById(int id) {

        String sql =
                "SELECT * FROM department WHERE department_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setInt(1, id);

            try (ResultSet rs = ps.executeQuery()) {

                if (rs.next()) {
                    return new Department(
                            rs.getInt("department_id"),
                            rs.getString("department_name")
                    );
                }
            }

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return null;
    }

    public boolean updateDepartment(Department department) {

        String sql =
                "UPDATE department SET department_name=? WHERE department_id=?";

        try (Connection con = DatabaseConnection.getConnection();
             PreparedStatement ps = con.prepareStatement(sql)) {

            ps.setString(1, department.getDepartmentName());
            ps.setInt(2, department.getDepartmentId());

            return ps.executeUpdate() > 0;

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }

        return false;
    }

    public boolean deleteDepartment(int id) {

        String sql =
                "DELETE FROM department WHERE department_id=?";

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