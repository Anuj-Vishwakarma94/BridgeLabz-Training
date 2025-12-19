//Created class Named FactorialNumber
import java.util.Scanner;
public class FactorialNumber{
   public static void main(String[]args){

    //take input from the user and check whether it is a positive integer
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();

    if(number<=0){
        System.out.println("Please enter a positive integer");
    }
    else{
        int factorial=1;
        int i=1;

        //use while loop to calculate factorial
        while(i<=number){
            factorial=factorial*i;
            i++;
        }

        //print the factorial value
        System.out.println("Factorial of " + number + " is " + factorial);
    }
   }
}
