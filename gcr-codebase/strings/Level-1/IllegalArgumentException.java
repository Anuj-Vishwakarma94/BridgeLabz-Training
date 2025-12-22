//Created class Named IllegalArgumentException
import java.util.Scanner;
public class IllegalArgumentException{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input string
    String text=input.next();

    //call method to handle IllegalArgumentException
    handleException(text);
   }

   //method to generate IllegalArgumentException
   public static void generateException(String text){

       //start index is greater than end index
       System.out.println(text.substring(5,2));
   }

   //method to handle IllegalArgumentException using try-catch
   public static void handleException(String text){

       try{
           generateException(text);
       }
       catch(IllegalArgumentException e){
           System.out.println("IllegalArgumentException handled successfully");
       }
       catch(RuntimeException e){
           System.out.println("Generic RuntimeException handled successfully");
       }
   }
}
