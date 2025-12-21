//Created class Named FactorsOperations
import java.util.Scanner;
public class FactorsOperations{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input for number
    int number=input.nextInt();

    int factors[]=findFactors(number);

    //display factors
    System.out.println("Factors are : ");
    for(int i=0;i<factors.length;i++){
        System.out.println(factors[i]);
    }

    int greatest=findGreatestFactor(factors);
    int sum=findSumOfFactors(factors);
    long product=findProductOfFactors(factors);
    double cubeProduct=findProductOfCubeOfFactors(factors);

    //display results
    System.out.println("Greatest Factor = " + greatest);
    System.out.println("Sum of Factors = " + sum);
    System.out.println("Product of Factors = " + product);
    System.out.println("Product of Cube of Factors = " + cubeProduct);
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

   //method to find greatest factor
   public static int findGreatestFactor(int factors[]){
       int greatest=factors[0];

       for(int i=1;i<factors.length;i++){
           if(factors[i]>greatest){
               greatest=factors[i];
           }
       }

       return greatest;
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
   public static long findProductOfFactors(int factors[]){
       long product=1;

       for(int i=0;i<factors.length;i++){
           product=product*factors[i];
       }

       return product;
   }

   //method to find product of cube of factors
   public static double findProductOfCubeOfFactors(int factors[]){
       double product=1;

       for(int i=0;i<factors.length;i++){
           product=product*Math.pow(factors[i],3);
       }

       return product;
   }
}
