package com.linearandbinarysearch.stringbuilder;
import java.util.Scanner;
public class ReverseString {
    public static void main(String[] args) {
    	System.out.print("Enter a String: ");
        Scanner sc=new Scanner(System.in);
    	String s = sc.next();
        StringBuilder sb = new StringBuilder();
        sb.append(s);
        sb.reverse();
        String reversed = sb.toString();
        System.out.println("Original: " + s);
        System.out.println("Reversed: " + reversed);
        sc.close();
    }
}
