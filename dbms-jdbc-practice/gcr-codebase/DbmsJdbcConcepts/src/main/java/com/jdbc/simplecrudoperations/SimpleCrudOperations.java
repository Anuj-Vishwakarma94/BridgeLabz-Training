package com.jdbc.simplecrudoperations;

import java.sql.*;
import java.util.*;

public class SimpleCrudOperations {

    static final String url="jdbc:mysql://localhost:3306/sqlpractice";
    static final String username="root";
    static final String password="Gamebit@8878";

    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        while(true) {

            System.out.println("\n===== Employee Management System =====");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Update Salary");
            System.out.println("4. Delete Employee");
            System.out.println("5. Search Employee");
            System.out.println("6. Exit");

            System.out.print("Enter choice: ");
            int choice = sc.nextInt();

            switch(choice) {

                case 1: addEmployee(); break;
                case 2: viewEmployees(); break;
                case 3: updateSalary(); break;
                case 4: deleteEmployee(); break;
                case 5: searchEmployee(); break;
                case 6: System.exit(0);
            }
        }
    }

    // ADD EMPLOYEE
    static void addEmployee() {

        try(Connection con = DriverManager.getConnection(url, username, password)) {

            System.out.print("Enter ID: ");
            int id = sc.nextInt();

            sc.nextLine();

            System.out.print("Enter Name: ");
            String name = sc.nextLine();

            System.out.print("Enter Salary: ");
            double salary = sc.nextDouble();

            String query = "INSERT INTO employees VALUES (?, ?, ?)";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setDouble(3, salary);

            ps.executeUpdate();

            System.out.println("Employee Added Successfully");

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // VIEW ALL EMPLOYEES
    static void viewEmployees() {

        try(Connection con = DriverManager.getConnection(url, username, password)) {

            String query = "SELECT * FROM employees";

            Statement st = con.createStatement();

            ResultSet rs = st.executeQuery(query);

            while(rs.next()) {

                System.out.println(
                        "ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Salary: " + rs.getDouble("salary"));
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // UPDATE SALARY
    static void updateSalary() {

        try(Connection con = DriverManager.getConnection(url, username, password)) {

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            System.out.print("Enter New Salary: ");
            double salary = sc.nextDouble();

            String query = "UPDATE employees SET salary=? WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setDouble(1, salary);
            ps.setInt(2, id);

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("Salary Updated Successfully");
            else
                System.out.println("Employee Not Found");

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // DELETE EMPLOYEE
    static void deleteEmployee() {

        try(Connection con = DriverManager.getConnection(url, username, password)) {

            System.out.print("Enter Employee ID: ");
            int id = sc.nextInt();

            String query = "DELETE FROM employees WHERE id=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setInt(1, id);

            int rows = ps.executeUpdate();

            if(rows > 0)
                System.out.println("Employee Deleted Successfully");
            else
                System.out.println("Employee Not Found");

        } catch(Exception e) {
            System.out.println(e);
        }
    }

    // SEARCH EMPLOYEE
    static void searchEmployee() {

        try(Connection con = DriverManager.getConnection(url, username, password)) {

            sc.nextLine();

            System.out.print("Enter Employee Name: ");
            String name = sc.nextLine();

            String query = "SELECT * FROM employees WHERE name=?";

            PreparedStatement ps = con.prepareStatement(query);

            ps.setString(1, name);

            ResultSet rs = ps.executeQuery();

            if(rs.next()) {

                System.out.println(
                        "ID: " + rs.getInt("id") +
                        ", Name: " + rs.getString("name") +
                        ", Salary: " + rs.getDouble("salary"));
            }
            else {
                System.out.println("Employee Not Found");
            }

        } catch(Exception e) {
            System.out.println(e);
        }
    }
}
