package com.healthclinic.HealthClinicJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/HealthClinicAppJDBC";
        String username = "root";
        String password = "PassWord";

        try {
            Connection con = DriverManager.getConnection(url, username, password);
            System.out.println("Database connected successfully!");
            con.close();
        } 
        catch (SQLException e) {
            e.printStackTrace();
        }
    }
}