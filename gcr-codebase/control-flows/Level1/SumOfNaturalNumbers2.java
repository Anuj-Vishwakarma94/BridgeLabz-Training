//Created class Named SumOfNaturalNumbers2
import java.util.Scanner;
public class SumOfNaturalNumbersFor{
   public static void main(String[]args){

    //take input from the user and check whether it is a natural number
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();

    if(number<=0){
        System.out.println("Not a Natural Number");
    }
    else{
        int sumFor=0;

        //calculate sum using for loop
        for(int i=1;i<=n;i++){
            sumFor=sumFor+i;
        }

        //calculate sum using formula and compare results
        int sumFormula=number*(number+1)/2;

        if(sumFor==sumFormula){
            System.out.println("Sum using for loop = " + sumFor);
            System.out.println("Sum using formula = " + sumFormula);
            System.out.println("Both computations are correct");
        }
        else{
		    System.out.println("Sum using for loop = " + sumFor);
            System.out.println("Sum using formula = " + sumFormula);
            System.out.println("Results do not match");
        }
    }
   }
}
