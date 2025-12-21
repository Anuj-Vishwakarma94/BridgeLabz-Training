//Created class Named SumOfNaturalNumbers
import java.util.Scanner;
public class SumOfNaturalNumbers{
   public static void main(String[]args){

    //take input from the user and check whether it is a natural number
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();

    if(number<=0){
        System.out.println("Not a Natural Number");
    }
    else{
        int sumRecursive=findSumRecursive(number);
        int sumFormula=findSumFormula(number);

        //compare both results
        if(sumRecursive==sumFormula){
            System.out.println("Sum using recursion = " + sumRecursive);
            System.out.println("Sum using formula = " + sumFormula);
            System.out.println("Both computations are correct");
        }
        else{
            System.out.println("Results do not match");
        }
    }
   }

   //method to find sum using recursion
   public static int findSumRecursive(int n){
       if(n==1){
           return 1;
       }
       return n+findSumRecursive(n-1);
   }

   //method to find sum using formula
   public static int findSumFormula(int n){
       return n*(n+1)/2;
   }
}
