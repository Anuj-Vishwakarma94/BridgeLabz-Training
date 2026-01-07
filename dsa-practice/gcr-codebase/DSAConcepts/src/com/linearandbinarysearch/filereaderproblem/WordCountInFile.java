package com.linearandbinarysearch.filereaderproblem;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WordCountInFile {
    public static void main(String[] args) {
        String fileName = "input.txt";
        String target = "hello";
        int count = 0;

        try {
            FileReader fr = new FileReader(fileName);
            BufferedReader br = new BufferedReader(fr);

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.split("\\s+");
                for (String w : words) {
                    if (w.equalsIgnoreCase(target)) {
                        count++;
                    }
                }
            }

            br.close();
            fr.close();

            System.out.println("Word occurrence count: " + count);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
