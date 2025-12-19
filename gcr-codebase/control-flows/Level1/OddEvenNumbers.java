//Created class Named OddEvenNumbers
import java.util.Scanner;
public class OddEvenNumbers{
   public static void main(String[]args){

    //take input from the user and check whether it is a natural number
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();

    if(number<=0){
        System.out.println("Not a Natural Number");
    }
    else{

        //use for loop to check odd and even numbers
        for(int i=1;i<=number;i++){
            if(i%2==0){
                System.out.println(i + " is Even Number");
            }
            else{
                System.out.println(i + " is Odd Number");
            }
        }
    }
   }
}
