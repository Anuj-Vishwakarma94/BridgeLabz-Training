//Created class Named RemainderAndQuotient
import java.util.Scanner;
public class RemainderAndQuotient{
   public static void main(String[]args){

    //take input for number and divisor
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();
    int divisor=input.nextInt();

    int result[]=findRemainderAndQuotient(number,divisor);

    //display the quotient and remainder
    System.out.println("Quotient = " + result[0]);
    System.out.println("Remainder = " + result[1]);
   }

   //method to find quotient and remainder
   public static int[] findRemainderAndQuotient(int number,int divisor){
       int quotient=number/divisor;
       int remainder=number%divisor;

       return new int[]{quotient,remainder};
   }
}
