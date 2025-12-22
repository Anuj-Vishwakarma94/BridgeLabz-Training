//Created class Named SubstringComparison
import java.util.Scanner;
public class SubstringComparison{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input string and start & end index
    String text=input.next();
    int start=input.nextInt();
    int end=input.nextInt();

    //create substring using charAt method
    String subCharAt=createSubstringUsingCharAt(text,start,end);

    //create substring using built-in substring method
    String subBuiltIn=text.substring(start,end);

    //compare the two substrings
    boolean isEqual=compareStringsUsingCharAt(subCharAt,subBuiltIn);

    //display results
    System.out.println("Substring using charAt() = " + subCharAt);
    System.out.println("Substring using substring() = " + subBuiltIn);

    if(isEqual){
        System.out.println("Both substrings are equal");
    }
    else{
        System.out.println("Both substrings are NOT equal");
    }
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