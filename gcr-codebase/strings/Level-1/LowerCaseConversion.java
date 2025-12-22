//Created class Named LowerCaseConversion
import java.util.Scanner;
public class LowerCaseConversion{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take complete text input
    String text=input.nextLine();

    //convert text to lowercase using user-defined method
    String userLowerCase=convertToLowerCaseUsingCharAt(text);

    //convert text to lowercase using built-in method
    String builtInLowerCase=text.toLowerCase();

    //compare both strings
    boolean result=compareStringsUsingCharAt(userLowerCase,builtInLowerCase);

    //display results
    System.out.println("Lowercase using charAt() : " + userLowerCase);
    System.out.println("Lowercase using toLowerCase() : " + builtInLowerCase);

    if(result){
        System.out.println("Both results are equal");
    }
    else{
        System.out.println("Both results are NOT equal");
    }
   }

   //method to convert text to lowercase using charAt and ASCII logic
   public static String convertToLowerCaseUsingCharAt(String text){
       String result="";

       for(int i=0;i<text.length();i++){
           char ch=text.charAt(i);

           if(ch>='A' && ch<='Z'){
               ch=(char)(ch+32);
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
