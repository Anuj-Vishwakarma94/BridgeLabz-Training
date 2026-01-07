package com.linearandbinarysearch.stringbuffer;

import java.util.Scanner;

public class StringConcatenator {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); 

        String[] arr = new String[n];

        System.out.println("Enter the strings one by one:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLine();
        }

        StringBuffer sb = new StringBuffer();

        for (String str : arr) {
            sb.append(str);
        }

        System.out.println("Concatenated String: " + sb.toString());

        sc.close();
    }
}
