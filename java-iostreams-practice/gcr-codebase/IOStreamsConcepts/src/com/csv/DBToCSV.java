package com.csv;

import java.io.*;
import java.sql.*;

public class DBToCSV {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/test?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true",
                "root",
                "Gamebit@8878"
            );

            Statement s = c.createStatement();
            ResultSet rs = s.executeQuery("select * from employee");

            BufferedWriter bw = new BufferedWriter(new FileWriter("src/com/csv/employees.csv"));
            bw.write("ID,Name,Department,Salary\n");

            while (rs.next()) {
                bw.write(
                    rs.getInt("id") + "," +
                    rs.getString("name") + "," +
                    rs.getString("department") + "," +
                    rs.getInt("salary") + "\n"
                );
            }

            bw.close();
            c.close();

            System.out.println("DB → CSV successful");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
