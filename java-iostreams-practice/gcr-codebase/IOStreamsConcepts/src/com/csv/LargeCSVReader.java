package com.csv;

import java.io.*;

public class LargeCSVReader {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new FileReader("large.csv"));
        int count = 0;
        while (br.readLine() != null) {
            count++;
            if (count % 100 == 0)
                System.out.println("Processed: " + count);
        }
        br.close();
    }
}
