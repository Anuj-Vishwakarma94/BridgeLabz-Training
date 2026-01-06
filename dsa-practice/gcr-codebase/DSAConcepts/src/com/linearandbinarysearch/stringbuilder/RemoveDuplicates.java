package com.linearandbinarysearch.stringbuilder;

import java.util.Scanner;
import java.util.HashSet;

public class RemoveDuplicates {

    public static void main(String[] args) {
    	System.out.print("Enter a String: ");
        Scanner sc=new Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder();
        HashSet<Character> seen = new HashSet<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!seen.contains(ch)) {
                seen.add(ch);
                sb.append(ch);
            }
        }

        String result = sb.toString();

        System.out.println("Original: " + s);
        System.out.println("Without duplicates: " + result);
        sc.close();
    }
}
