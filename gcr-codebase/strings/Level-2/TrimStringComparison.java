//Created class Named TrimStringComparison
import java.util.Scanner;
public class TrimStringComparison{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take complete text input
    String text=input.nextLine();

    //find start and end index after trimming spaces
    int indexes[]=findTrimIndexes(text);

    //create trimmed string using charAt()
    String userTrimmed=createSubstringUsingCharAt(text,indexes[0],indexes[1]);

    //trim string using built-in method
    String builtInTrimmed=text.trim();

    //compare both trimmed strings
    boolean result=compareStringsUsingCharAt(userTrimmed,builtInTrimmed);

    //display results
    System.out.println("Trimmed using charAt() : [" + userTrimmed + "]");
    System.out.println("Trimmed using trim()   : [" + builtInTrimmed + "]");

    if(result){
        System.out.println("Both trimmed strings are equal");
    }
    else{
        System.out.println("Both trimmed strings are NOT equal");
    }
   }

   //method to find start and end index after trimming spaces
   public static int[] findTrimIndexes(String text){
       int start=0;
       int end=0;

       //find starting index (skip leading spaces)
       for(int i=0;i<text.length();i++){
           if(text.charAt(i)!=' '){
               start=i;
               break;
           }
       }

       //find ending index (skip trailing spaces)
       for(int i=text.length()-1;i>=0;i--){
           if(text.charAt(i)!=' '){
               end=i+1;
               break;
           }
       }

       return new int[]{start,end};
   }

   //method to create substring using charAt()
   public static String createSubstringUsingCharAt(String text,int start,int end){
       String result="";

       for(int i=start;i<end;i++){
           result=result+text.charAt(i);
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
