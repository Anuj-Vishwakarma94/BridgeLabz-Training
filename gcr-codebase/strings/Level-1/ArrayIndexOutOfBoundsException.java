//Created class Named ArrayIndexOutOfBoundsException
import java.util.Scanner;
public class ArrayIndexOutOfBoundsException{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input for array size
    int size=input.nextInt();
    String names[]=new String[size];

    //take input for names
    for(int i=0;i<size;i++){
        names[i]=input.next();
    }

    //call method to handle ArrayIndexOutOfBoundsException
    handleException(names);
   }

   //method to generate ArrayIndexOutOfBoundsException
   public static void generateException(String names[]){

       //this will generate ArrayIndexOutOfBoundsException
       System.out.println(names[names.length]);
   }

   //method to handle ArrayIndexOutOfBoundsException using try-catch
   public static void handleException(String names[]){

       try{
           generateException(names);
       }
       catch(ArrayIndexOutOfBoundsException e){
           System.out.println("ArrayIndexOutOfBoundsException handled successfully");
       }
       catch(RuntimeException e){
           System.out.println("Generic RuntimeException handled successfully");
       }
   }
}
