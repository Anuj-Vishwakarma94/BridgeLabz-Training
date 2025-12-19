//Created class Named SumOfNaturalNumbers
import java.util.Scanner;
public class SumOfNaturalNumbers{
   public static void main(String[]args){

    //take input from the user and check whether it is a natural number
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();

    if(n<=0){
        System.out.println("Not a Natural Number");
    }
    else{
        int sumWhile=0;
        int i=1;

        //calculate sum using while loop
        while(i<=n){
            sumWhile=sumWhile+i;
            i++;
        }

        //calculate sum using formula and compare results
        int sumFormula=number*(number+1)/2;

        if(sumWhile==sumFormula){
            System.out.println("Sum using while loop is " + sumWhile);
            System.out.println("Sum using formula is " + sumFormula);
            System.out.println("Both computations are correct");
        }
        else{
		    System.out.println("Sum using while loop is " + sumWhile);
            System.out.println("Sum using formula is " + sumFormula);
            System.out.println("Results do not match");
        }
    }
   }
}
