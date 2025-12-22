//Created class Named StringIOB
import java.util.Scanner;
public class StringIOB{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input string
    String text=input.next();

    //call method to handle StringIOB
    handleException(text);
   }

   //method to generate StringIOB
   public static void generateException(String text){

       //this will generate StringIOB
       System.out.println(text.charAt(text.length()));
   }

   //method to handle StringIOB 
   public static void handleException(String text){

       try{
           generateException(text);
       }
       catch(StringIndexOutOfBoundsException e){
           System.out.println("StringIndexOutOfBoundsException handled successfully");
       }
   }
}
