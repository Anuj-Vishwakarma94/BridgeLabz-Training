//Created class Named ToggleCaseString
import java.util.Scanner;
public class ToggleCaseString{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input text
    String text=input.nextLine();
    String result=toggleCase(text);

    //display result
    System.out.println("Toggled String : " + result);
   }

   //method to toggle case of characters
   public static String toggleCase(String text){
       String output="";
       for(int i=0;i<text.length();i++){
           char ch=text.charAt(i);
           if(ch>='A' && ch<='Z'){
               output=output+(char)(ch+32);
           }
           else if(ch>='a' && ch<='z'){
               output=output+(char)(ch-32);
           }
           else{
               output=output+ch;
           }
       }
       return output;
   }
}