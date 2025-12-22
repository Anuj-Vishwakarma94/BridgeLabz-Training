//Created class Named ArrayComparison
import java.util.Scanner;
public class ArrayComparison{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input string
    String text=input.next();

    //get character array using user-defined method
    char userArray[]=getCharactersUsingCharAt(text);

    //get character array using built-in method
    char builtInArray[]=text.toCharArray();

    //compare both character arrays
    boolean result=compareCharArrays(userArray,builtInArray);

    //display result
    System.out.println("Comparison Result = " + result);

    if(result){
        System.out.println("Both character arrays are equal");
    }
    else{
        System.out.println("Both character arrays are NOT equal");
    }
   }

   //method to return characters using charAt()
   public static char[] getCharactersUsingCharAt(String text){
       char chars[]=new char[text.length()];

       for(int i=0;i<text.length();i++){
           chars[i]=text.charAt(i);
       }

       return chars;
   }

   //method to compare two character arrays
   public static boolean compareCharArrays(char arr1[],char arr2[]){

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
}