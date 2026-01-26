package com.csv;

import java.io.*;

public class ReadCSV {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        String line;
        br.readLine();
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            System.out.println("ID=" + d[0] + " Name=" + d[1] + " Age=" + d[2] + " Marks=" + d[3]);
        }
        br.close();
    }
}
