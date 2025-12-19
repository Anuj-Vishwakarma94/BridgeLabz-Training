//Created class Named FizzBuzzArray
import java.util.Scanner;
public class FizzBuzzArray{
   public static void main(String[]args){

    //take input from the user and check whether it is a positive integer
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();
    if(number<=0){
        System.out.println("Please enter a positive integer");
    }
    String results[]=new String[number+1];

    //use loop to store values in the array
    for(int i=0;i<=number;i++){
        if(i==0){
            results[i]="0";
        }
        else if(i%3==0 && i%5==0){
            results[i]="FizzBuzz";
        }
        else if(i%3==0){
            results[i]="Fizz";
        }
        else if(i%5==0){
            results[i]="Buzz";
        }
        else{
            results[i]=String.valueOf(i);
        }
    }

    //Print the array values with position
    for(int i=1;i<=number;i++){
        System.out.println("Position " + i + " = " + results[i]);
    }
   }
}
