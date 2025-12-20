//Created class Named ChocolateDistribution
import java.util.Scanner;
public class ChocolateDistribution{
   public static void main(String[]args){

    //take input for number of chocolates and number of children
    Scanner input=new Scanner(System.in);
    int numberOfChocolates=input.nextInt();
    int numberOfChildren=input.nextInt();

    int result[]=findNumberOfChocolate(numberOfChocolates,numberOfChildren);

    //display chocolates per child and remaining chocolates
    System.out.println("Each child will get " + result[0] + " chocolates");
    System.out.println("Remaining chocolates = " + result[1]);
   }

   //method to find quotient and remainder
   public static int[] findNumberOfChocolate(int number,int divisor){
       int quotient=number/divisor;
       int remainder=number%divisor;

       return new int[]{quotient,remainder};
   }
}
