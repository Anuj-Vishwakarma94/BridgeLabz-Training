// Created class named AnagramCheck
import java.util.Scanner;
public class AnagramCheck {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input strings
        String s1 = input.nextLine();
        String s2 = input.nextLine();
        if(isAnagram(s1, s2)){
            System.out.println("The given strings are Anagrams");
        }
        else{
            System.out.println("The given strings are NOT Anagrams");
        }
    }

    // Method to check whether two strings are anagrams
    public static boolean isAnagram(String s1, String s2){
        if(s1.length()!=s2.length()){
            return false;
        }
        int frequency[]=new int[256];
        for(int i=0;i<s1.length();i++){
            char ch=s1.charAt(i);
            frequency[ch]++;
        }
        for(int i=0;i<s2.length();i++){
            char ch=s2.charAt(i);
            frequency[ch]--;
        }
        for(int i=0;i<frequency.length;i++){
            if(frequency[i]!=0){
                return false;
            }
        }
        return true;
    }
}
