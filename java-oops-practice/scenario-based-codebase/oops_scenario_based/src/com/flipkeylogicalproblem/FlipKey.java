package com.flipkeylogicalproblem;

import java.util.Scanner;
public class FlipKey {
	public static String CleanseAndInvert(String input) {
		if(input== null || input.length()<6) {
			return "";
		}
		for(int i=0;i<input.length();i++) {
			char ch = input.charAt(i);
            if(!(ch>='A' && ch<='Z') && (!(ch>='a' && ch<='z'))){
            	return "";
            }
        }
        input = input.toLowerCase();
        String result = "";
        for(int i=input.length()-1;i>=0;i--) {
            char c = input.charAt(i);
            if(c%2!=0){
                if(result.length() % 2 == 0) {
                	result += Character.toUpperCase(c);
                }
                else{
                    result += c;
                }    
            }
        }
		return result;
	}
	
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		System.out.print("Enter a String: ");
		String input=sc.nextLine();
		String output=CleanseAndInvert(input);
		if(output.equals("")){
			System.out.println("Invalid input");
		}
		else {
			System.out.println("The generated key is :"+output);
		}
	}
}
