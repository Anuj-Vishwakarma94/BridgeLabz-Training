package com.csv;

import java.io.*;

public class FilterStudents {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/com/csv/students.csv"));
        String line = br.readLine();
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            if (Integer.parseInt(d[2]) > 20)
                System.out.println(line);
        }
        br.close();
    }
}
