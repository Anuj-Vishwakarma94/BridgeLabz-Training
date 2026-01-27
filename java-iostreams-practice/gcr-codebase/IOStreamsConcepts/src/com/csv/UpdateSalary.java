package com.csv;

import java.io.*;

public class UpdateSalary {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("src/com/csv/employees.csv"));
        BufferedWriter bw = new BufferedWriter(new FileWriter("src/com/csv/updated.csv"));
        String line = br.readLine();
        bw.write(line + "\n");
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            if (d[2].equals("IT"))
                d[3] = String.valueOf((int)(Integer.parseInt(d[3]) * 1.1));
            bw.write(String.join(",", d) + "\n");
        }
        br.close();
        bw.close();
    }
}
