//Created class Named NumberChecker3
import java.util.Scanner;
public class NumberChecker3{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input for number
    int number=input.nextInt();

    int count=countDigits(number);
    int digits[]=storeDigits(number,count);

    System.out.println("Count of digits = " + count);

    int reversedDigits[]=reverseDigits(digits);

    //check palindrome number
    if(isPalindrome(digits,reversedDigits)){
        System.out.println("Palindrome Number");
    }
    else{
        System.out.println("Not a Palindrome Number");
    }

    //check duck number
    if(isDuckNumber(digits)){
        System.out.println("Duck Number");
    }
    else{
        System.out.println("Not a Duck Number");
    }
   }

   //method to find count of digits
   public static int countDigits(int number){
       int count=0;

       while(number!=0){
           count++;
           number=number/10;
       }

       return count;
   }

   //method to store digits in array
   public static int[] storeDigits(int number,int count){
       int digits[]=new int[count];
       int index=0;

       while(number!=0){
           digits[index]=number%10;
           number=number/10;
           index++;
       }

       return digits;
   }

   //method to reverse digits array
   public static int[] reverseDigits(int digits[]){
       int reversed[]=new int[digits.length];
       int index=0;

       for(int i=digits.length-1;i>=0;i--){
           reversed[index]=digits[i];
           index++;
       }

       return reversed;
   }

   //method to compare two arrays
   public static boolean compareArrays(int arr1[],int arr2[]){
       if(arr1.length!=arr2.length){
           return false;
       }

       for(int i=0;i<arr1.length;i++){
           if(arr1[i]!=arr2[i]){
               return false;
           }
       }

       return true;
   }

   //method to check palindrome number
   public static boolean isPalindrome(int digits[],int reversed[]){
       return compareArrays(digits,reversed);
   }

   //method to check duck number
   public static boolean isDuckNumber(int digits[]){
       for(int i=0;i<digits.length;i++){
           if(digits[i]==0){
               return true;
           }
       }
       return false;
   }
}
