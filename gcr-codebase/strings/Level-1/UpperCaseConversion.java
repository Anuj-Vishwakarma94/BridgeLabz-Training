//Created class Named UpperCaseConversion
import java.util.Scanner;
public class UpperCaseConversion{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take complete text input
    String text=input.nextLine();

    //convert text to uppercase using user-defined method
    String userUpperCase=convertToUpperCaseUsingCharAt(text);

    //convert text to uppercase using built-in method
    String builtInUpperCase=text.toUpperCase();

    //compare both strings
    boolean result=compareStringsUsingCharAt(userUpperCase,builtInUpperCase);

    //display results
    System.out.println("Uppercase using charAt() : " + userUpperCase);
    System.out.println("Uppercase using toUpperCase() : " + builtInUpperCase);

    if(result){
        System.out.println("Both results are equal");
    }
    else{
        System.out.println("Both results are NOT equal");
    }
   }

   //method to convert text to uppercase using charAt and ASCII logic
   public static String convertToUpperCaseUsingCharAt(String text){
       String result="";

       for(int i=0;i<text.length();i++){
           char ch=text.charAt(i);

           if(ch>='a' && ch<='z'){
               ch=(char)(ch-32);
           }

           result=result+ch;
       }

       return result;
   }

   //method to compare two strings using charAt()
   public static boolean compareStringsUsingCharAt(String s1,String s2){

       if(s1.length()!=s2.length()){
           return false;
       }

       for(int i=0;i<s1.length();i++){
           if(s1.charAt(i)!=s2.charAt(i)){
               return false;
           }
       }

       return true;
   }
}
