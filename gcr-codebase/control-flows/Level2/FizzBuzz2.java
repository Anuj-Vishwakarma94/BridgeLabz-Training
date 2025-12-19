//Created class Named FizzBuzz2
import java.util.Scanner;
public class FizzBuzz2{
   public static void main(String[]args){

    //take input from the user and check whether it is a positive integer
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();

    if(number<=0){
        System.out.println("Please enter a positive integer");
    }
    else{
        int i=1;

        //use while loop to print FizzBuzz
        while(i<=number){
            if(i%3==0 && i%5==0){
                System.out.println("FizzBuzz");
            }
            else if(i%3==0){
                System.out.println("Fizz");
            }
            else if(i%5==0){
                System.out.println("Buzz");
            }
            else{
                System.out.println(i);
            }
            i++;
        }
    }
   }
}
