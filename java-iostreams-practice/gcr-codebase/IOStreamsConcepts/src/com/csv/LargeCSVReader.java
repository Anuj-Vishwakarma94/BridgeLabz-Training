package com.csv;

import java.io.*;

public class LargeCSVReader {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(
                new FileReader("src/com/csv/large.csv"));

        String line;
        int count = 0;

        while ((line = br.readLine()) != null) {
            count++;
            if (count % 100 == 0) {
                System.out.println("Processed: " + count);
            }
        }

        br.close();
        System.out.println("Total lines: " + count);
    }
}
