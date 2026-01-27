package com.csv;

import java.io.*;
import java.util.*;

public class DetectDuplicates {
    public static void main(String[] args) throws Exception {
        Set<String> seen = new HashSet<>();
        BufferedReader br = new BufferedReader(new FileReader("src/com/csv/data.csv"));
        br.readLine();
        String line;
        while ((line = br.readLine()) != null) {
            String id = line.split(",")[0];
            if (!seen.add(id))
                System.out.println("Duplicate: " + line);
        }
        br.close();
    }
}
