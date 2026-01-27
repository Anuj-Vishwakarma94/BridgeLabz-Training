package com.csv;

import java.io.*;

public class ReadCSV {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new FileReader("src/com/csv/students.csv"));

        String line;

        br.readLine(); // skip header

        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            if (data.length < 3) continue;

            String id = data[0];
            String name = data[1];
            String age = data[2];

            System.out.println(id + " " + name + " " + age);
        }

        br.close();
    }
}
