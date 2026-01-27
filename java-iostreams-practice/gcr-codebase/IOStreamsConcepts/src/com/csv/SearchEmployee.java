package com.csv;

import java.io.*;

public class SearchEmployee {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/com/csv/employees.csv"));
        String name = "Anuj";
        String line = br.readLine();
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            if (d[1].equalsIgnoreCase(name))
                System.out.println(d[2] + " " + d[3]);
        }
        br.close();
    }
}
