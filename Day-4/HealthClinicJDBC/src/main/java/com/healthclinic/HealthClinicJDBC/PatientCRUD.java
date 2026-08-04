package com.healthclinic.HealthClinicJDBC;

import java.sql.*;
import java.util.Scanner;

public class PatientCRUD {

    static final String URL = "jdbc:mysql://localhost:3306/HealthClinicAppJDBC";
    static final String USER = "root";
    static final String PASSWORD = "PassWord";

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        try {

            Connection con = DriverManager.getConnection(URL, USER, PASSWORD);

            while (true) {

                System.out.println("\n===== HEALTH CLINIC MENU =====");
                System.out.println("1. Create Patient Table");
                System.out.println("2. Add Patient");
                System.out.println("3. View Patients");
                System.out.println("4. Update Patient");
                System.out.println("5. Delete Patient");
                System.out.println("6. Exit");

                System.out.print("Enter Choice: ");
                int choice = sc.nextInt();
                sc.nextLine();

                switch (choice) {

                case 1:

                    String createTable = "CREATE TABLE IF NOT EXISTS patient ("
                            + "patient_id INT PRIMARY KEY AUTO_INCREMENT,"
                            + "name VARCHAR(50),"
                            + "age INT,"
                            + "gender VARCHAR(10),"
                            + "phone VARCHAR(15))";

                    Statement stmt = con.createStatement();
                    stmt.executeUpdate(createTable);
                    System.out.println("Patient table created successfully.");
                    stmt.close();

                    break;

                case 2:

                    String insert = "INSERT INTO patient(name,age,gender,phone) VALUES(?,?,?,?)";

                    PreparedStatement ps = con.prepareStatement(insert);

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Gender: ");
                    String gender = sc.nextLine();

                    System.out.print("Enter Phone: ");
                    String phone = sc.nextLine();

                    ps.setString(1, name);
                    ps.setInt(2, age);
                    ps.setString(3, gender);
                    ps.setString(4, phone);

                    int rows = ps.executeUpdate();

                    if (rows > 0)
                        System.out.println("Patient Added Successfully.");

                    ps.close();

                    break;

                case 3:

                    String select = "SELECT * FROM patient";

                    PreparedStatement ps1 = con.prepareStatement(select);

                    ResultSet rs = ps1.executeQuery();

                    System.out.println("\n-----------------------------------------------");
                    System.out.println("ID\tName\tAge\tGender\tPhone");
                    System.out.println("-----------------------------------------------");

                    while (rs.next()) {

                        System.out.println(
                                rs.getInt("patient_id") + "\t"
                                + rs.getString("name") + "\t"
                                + rs.getInt("age") + "\t"
                                + rs.getString("gender") + "\t"
                                + rs.getString("phone"));
                    }

                    rs.close();
                    ps1.close();

                    break;

                case 4:

                    String update = "UPDATE patient SET phone=? WHERE patient_id=?";

                    PreparedStatement ps2 = con.prepareStatement(update);

                    System.out.print("Enter Patient ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter New Phone Number: ");
                    String newPhone = sc.nextLine();

                    ps2.setString(1, newPhone);
                    ps2.setInt(2, id);

                    int updated = ps2.executeUpdate();

                    if (updated > 0)
                        System.out.println("Patient Updated Successfully.");
                    else
                        System.out.println("Patient Not Found.");

                    ps2.close();

                    break;

                case 5:

                    String delete = "DELETE FROM patient WHERE patient_id=?";

                    PreparedStatement ps3 = con.prepareStatement(delete);

                    System.out.print("Enter Patient ID: ");
                    int deleteId = sc.nextInt();

                    ps3.setInt(1, deleteId);

                    int deleted = ps3.executeUpdate();

                    if (deleted > 0)
                        System.out.println("Patient Deleted Successfully.");
                    else
                        System.out.println("Patient Not Found.");

                    ps3.close();

                    break;

                case 6:

                    con.close();
                    sc.close();

                    System.out.println("Thank You!");
                    System.exit(0);

                default:

                    System.out.println("Invalid Choice");

                }

            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }

}