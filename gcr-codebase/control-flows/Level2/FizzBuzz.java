//Created class Named FizzBuzz
import java.util.Scanner;
public class FizzBuzz{
   public static void main(String[]args){

    //take input from the user and check whether it is a positive integer
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();
    if(number<=0){
        System.out.println("Please enter a positive integer");
    }
    else{

        //use for loop to print FizzBuzz
        for(int i=1;i<=number;i++){
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
        }
    }
   }
}
