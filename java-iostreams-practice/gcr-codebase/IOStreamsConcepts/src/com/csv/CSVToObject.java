package com.csv;

import java.io.*;

public class CSVToObject {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("src/com/csv/students.csv"));
        String line;

        br.readLine();

        while ((line = br.readLine()) != null) {
            String[] parts = line.split(",");

            if (parts.length < 3) continue;

            int id = Integer.parseInt(parts[0]);
            String name = parts[1];
            int age = Integer.parseInt(parts[2]);

            System.out.println(id + " " + name + " " + age);
        }

        br.close();
    }
}
