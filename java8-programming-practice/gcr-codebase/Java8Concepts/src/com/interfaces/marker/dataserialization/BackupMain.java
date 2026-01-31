package com.interfaces.marker.dataserialization;

import java.io.*;

public class BackupMain {

    private static void save(Employee emp) {
        try {
            ObjectOutputStream out =
                new ObjectOutputStream(new FileOutputStream("src/com/interfaces/marker/dataserialization/backup.dat"));

            out.writeObject(emp);
            out.close();
            System.out.println("Employee backed up successfully.");
        } catch (Exception e) {
            System.out.println("Backup failed: " + e.getMessage());
        }
    }

    private static void load() {
        try {
            ObjectInputStream in =
                new ObjectInputStream(new FileInputStream("src/com/interfaces/marker/dataserialization/backup.dat"));

            Employee emp = (Employee) in.readObject();
            in.close();
            emp.display();
        } catch (Exception e) {
            System.out.println("Restore failed: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Employee e = new Employee(101, "Anuj");
        save(e);
        load();
    }
}

