package com.csv;

import java.io.*;

public class JsonCsvConverter {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("students.json"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("students.csv"));
        String line;
        bw.write("id,name,age\n");
        while ((line = br.readLine()) != null) {
            if (line.contains("id"))
                bw.write(line.replaceAll("[^0-9,A-Za-z]", "") + "\n");
        }
        br.close();
        bw.close();
    }
}
