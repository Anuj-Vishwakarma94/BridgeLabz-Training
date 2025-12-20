//Created class Named NumberCheck
import java.util.Scanner;
public class NumberCheck{
   public static void main(String[]args){

    //take number as input
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();
    int numberType= numberType(number);

    //Print the type of number 0 for zero, 1 for positive and -1 for negative
    System.out.println(numberType);
   }

   //method to check the type of number 
   public static int numberType(int number){
       if(number>0){
       return(1);
       }
       else if(number<0){
       return(-1);
       }
       else{
       return(0);
       }

   }
}