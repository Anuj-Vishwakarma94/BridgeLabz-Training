//Created class Named StringLength
import java.util.Scanner;
public class StringLength{
   public static void main(String[]args){
    Scanner input=new Scanner(System.in);

    //take input string
    String text=input.next();

    //find length using user-defined method
    int userLength=findLengthWithoutUsingLength(text);

    //find length using built-in method
    int builtInLength=text.length();

    //display results
    System.out.println("Length using user-defined method = " + userLength);
    System.out.println("Length using built-in length() = " + builtInLength);
   }

   //method to find string length without using length()
   public static int findLengthWithoutUsingLength(String text){
       int count=0;
       try{
           while(true){
               text.charAt(count);
               count++;
           }
       }
       catch(StringIndexOutOfBoundsException e){
           //exception occurs when index exceeds string length
       }
       return count;
   }
}