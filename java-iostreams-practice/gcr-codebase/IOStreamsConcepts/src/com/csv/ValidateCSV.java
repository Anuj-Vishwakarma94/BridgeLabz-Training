package com.csv;

import java.io.*;
import java.util.regex.*;

public class ValidateCSV {
    public static void main(String[] args) throws Exception {
        Pattern email = Pattern.compile("^[\\w.-]+@[\\w.-]+$");
        Pattern phone = Pattern.compile("\\d{10}");
        BufferedReader br = new BufferedReader(new FileReader("src/com/csv/data.csv"));
        String line = br.readLine();
        while ((line = br.readLine()) != null) {
            String[] d = line.split(",");
            if (!email.matcher(d[2]).matches() || !phone.matcher(d[3]).matches())
                System.out.println("Invalid: " + line);
        }
        br.close();
    }
}
