package com.linearandbinarysearch.stringbuffer;
import java.util.Scanner;

public class StringPerformanceTest {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of iterations: ");
        int iterations = sc.nextInt();
        sc.nextLine();   

        System.out.print("Enter the string to append: ");
        String text = sc.nextLine();

        long startBuilder = System.nanoTime();

        StringBuilder sbuilder = new StringBuilder();
        for (int i = 0; i < iterations; i++) {
            sbuilder.append(text);
        }

        long endBuilder = System.nanoTime();
        long timeBuilder = endBuilder - startBuilder;

        long startBuffer = System.nanoTime();

        StringBuffer sbuffer = new StringBuffer();
        for (int i = 0; i < iterations; i++) {
            sbuffer.append(text);
        }

        long endBuffer = System.nanoTime();
        long timeBuffer = endBuffer - startBuffer;

        System.out.println("\n--- Performance Comparison ---");
        System.out.println("Time taken by StringBuilder: " + timeBuilder + " ns");
        System.out.println("Time taken by StringBuffer: " + timeBuffer + " ns");

        sc.close();
    }
}
