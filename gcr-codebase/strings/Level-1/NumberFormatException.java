//Created class Named NumberFormatException
import java.util.Scanner;
public class NumberFormatException{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input text
    String text=input.next();

    //call method to generate NumberFormatException
    //generateException(text);

    //call method to handle NumberFormatException
    handleException(text);
   }

   //method to generate NumberFormatException
   public static void generateException(String text){

       //this will generate NumberFormatException if text is not numeric
       int number=Integer.parseInt(text);
       System.out.println(number);
   }

   //method to handle NumberFormatException using try-catch
   public static void handleException(String text){

       try{
           generateException(text);
       }
       catch(NumberFormatException e){
           System.out.println("NumberFormatException handled successfully");
       }
       catch(RuntimeException e){
           System.out.println("Generic RuntimeException handled successfully");
       }
   }
}
