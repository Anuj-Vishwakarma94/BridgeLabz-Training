package com.linearandbinarysearch.challangeproblem;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class PerformanceTest {

    public static void main(String[] args) {

        int iterations = 1_000_000;
        String text = "hello";

        System.out.println("---- StringBuilder vs StringBuffer ----");

        long startBuilder = System.nanoTime();
        StringBuilder sbuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbuilder.append(text);
        }
        long timeBuilder = System.nanoTime() - startBuilder;

        long startBuffer = System.nanoTime();
        StringBuffer sbuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbuffer.append(text);
        }
        long timeBuffer = System.nanoTime() - startBuffer;

        System.out.println("Time taken by StringBuilder: " + timeBuilder + " ns");
        System.out.println("Time taken by StringBuffer: " + timeBuffer + " ns");


        System.out.println("\n---- FileReader Word Count ----");

        String fileName = "bigfile.txt";
        long startFR = System.nanoTime();
        long wordCountFR = 0;

        try {
            BufferedReader br = new BufferedReader(new FileReader(fileName));
            String line;

            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty())
                    wordCountFR += words.length;
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        long timeFR = System.nanoTime() - startFR;

        System.out.println("Word Count (FileReader): " + wordCountFR);
        System.out.println("Time taken by FileReader: " + timeFR + " ns");


        System.out.println("\n---- InputStreamReader Word Count ----");

        long startISR = System.nanoTime();
        long wordCountISR = 0;

        try {
            BufferedReader br = new BufferedReader(
                    new InputStreamReader(new FileInputStream(fileName), "UTF-8"));

            String line;
            while ((line = br.readLine()) != null) {
                String[] words = line.trim().split("\\s+");
                if (!line.trim().isEmpty())
                    wordCountISR += words.length;
            }

            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        long timeISR = System.nanoTime() - startISR;

        System.out.println("Word Count (InputStreamReader): " + wordCountISR);
        System.out.println("Time taken by InputStreamReader: " + timeISR + " ns");
    }
}
