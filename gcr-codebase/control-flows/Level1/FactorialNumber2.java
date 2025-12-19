//Created class Named FactorialNumber2
import java.util.Scanner;
public class FactorialNumber2{
   public static void main(String[]args){

    //take input from the user and check whether it is a positive integer
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();
    if(number<=0){
        System.out.println("Please enter a positive integer");
    }
    else{
        int factorial=1;

        //use for loop to calculate factorial
        for(int i=1;i<=number;i++){
            factorial=factorial*i;
        }

        //print the factorial value
        System.out.println("Factorial of " + number + " is " + factorial);
    }
   }
}
