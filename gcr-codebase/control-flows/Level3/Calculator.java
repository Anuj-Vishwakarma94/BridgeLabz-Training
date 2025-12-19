//Created class Named Calculator
import java.util.Scanner;
public class Calculator{
   public static void main(String[]args){

    //take input values from the user
    Scanner input=new Scanner(System.in);
    double first=input.nextDouble();
    double second=input.nextDouble();
    String op=input.next();

    //use switch case to perform calculation
    switch(op){
        case "+":
            System.out.println(first+second);
            break;

        case "-":
            System.out.println(first-second);
            break;

        case "*":
            System.out.println(first*second);
            break;

        case "/":
            System.out.println(first/second);
            break;

        default:
            System.out.println("Invalid Operator");
    }
   }
}
