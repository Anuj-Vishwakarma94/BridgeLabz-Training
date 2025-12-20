//Created class Named FactorsOperations
import java.util.Scanner;
public class FactorsOperations{
   public static void main(String[]args){

    //take input for the number
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();

    int factors[]=findFactors(number);

    //display the factors
    System.out.print("Factors = ");
    for(int i=0;i<factors.length;i++){
        System.out.print(factors[i]+ " ");
    }
        System.out.println();
    int sum=findSumOfFactors(factors);
    int product=findProductOfFactors(factors);
    double sumOfSquares=findSumOfSquaresOfFactors(factors);

    //display results
    System.out.println("Sum of factors = " + sum);
    System.out.println("Product of factors = " + product);
    System.out.println("Sum of squares of factors = " + sumOfSquares);
   }

   //method to find factors of a number
   public static int[] findFactors(int number){
       int count=0;

       for(int i=1;i<=number;i++){
           if(number%i==0){
               count++;
           }
       }

       int factors[]=new int[count];
       int index=0;

       for(int i=1;i<=number;i++){
           if(number%i==0){
               factors[index]=i;
               index++;
           }
       }

       return factors;
   }

   //method to find sum of factors
   public static int findSumOfFactors(int factors[]){
       int sum=0;

       for(int i=0;i<factors.length;i++){
           sum=sum+factors[i];
       }

       return sum;
   }

   //method to find product of factors
   public static int findProductOfFactors(int factors[]){
       int product=1;

       for(int i=0;i<factors.length;i++){
           product=product*factors[i];
       }

       return product;
   }

   //method to find sum of squares of factors
   public static double findSumOfSquaresOfFactors(int factors[]){
       double sum=0;

       for(int i=0;i<factors.length;i++){
           sum=sum+Math.pow(factors[i],2);
       }

       return sum;
   }
}
