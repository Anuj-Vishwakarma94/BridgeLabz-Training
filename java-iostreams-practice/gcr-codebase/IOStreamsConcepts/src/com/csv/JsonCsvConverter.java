package com.csv;

import java.io.*;

public class JsonCsvConverter {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new FileReader("src/com/csv/students.json"));
        BufferedWriter bw = new BufferedWriter(
                new FileWriter("src/com/csv/students.csv"));

        bw.write("id,name,age\n");

        String id = "", name = "", age = "";
        String line;

        while ((line = br.readLine()) != null) {
            if (line.contains("\"id\""))
                id = line.replaceAll("[^0-9]", "");
            else if (line.contains("\"name\""))
                name = line.replaceAll("[^A-Za-z]", "");
            else if (line.contains("\"age\""))
                age = line.replaceAll("[^0-9]", "");

            if (!id.isEmpty() && !name.isEmpty() && !age.isEmpty()) {
                bw.write(id + "," + name + "," + age + "\n");
                id = name = age = "";
            }
        }

        br.close();
        bw.close();
        System.out.println("CSV file created successfully");
    }
}
