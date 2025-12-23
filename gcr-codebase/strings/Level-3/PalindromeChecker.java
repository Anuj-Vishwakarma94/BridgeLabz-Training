//Created class Named PalindromeChecker
import java.util.Scanner;
public class PalindromeChecker{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take text input
    String text=input.next();

    //iterative comparison
    boolean result1=isPalindromeUsingLoop(text);

    //recursive comparison
    boolean result2=isPalindromeUsingRecursion(text,0,text.length()-1);

    //array comparison
    boolean result3=isPalindromeUsingArray(text);

    //display results
    System.out.println("Palindrome using Loop       : " + result1);
    System.out.println("Palindrome using Recursion  : " + result2);
    System.out.println("Palindrome using Array      : " + result3);
   }

   //method to check palindrome using loop
   public static boolean isPalindromeUsingLoop(String text){
       int start=0;
       int end=text.length()-1;

       while(start<end){
           if(text.charAt(start)!=text.charAt(end)){
               return false;
           }
           start++;
           end--;
       }

       return true;
   }

   //method to check palindrome using recursion
   public static boolean isPalindromeUsingRecursion(String text,int start,int end){
       if(start>=end){
           return true;
       }

       if(text.charAt(start)!=text.charAt(end)){
           return false;
       }

       return isPalindromeUsingRecursion(text,start+1,end-1);
   }
   public static boolean isPalindromeUsingArray(String text){

       char original[]=text.toCharArray();
       char reverse[]=reverseUsingCharAt(text);

       for(int i=0;i<original.length;i++){
           if(original[i]!=reverse[i]){
               return false;
           }
       }

       return true;
   }

   //method to reverse string using charAt()
   public static char[] reverseUsingCharAt(String text){
       char reverse[]=new char[text.length()];
       int index=0;

       for(int i=text.length()-1;i>=0;i--){
           reverse[index]=text.charAt(i);
           index++;
       }

       return reverse;
   }
}
