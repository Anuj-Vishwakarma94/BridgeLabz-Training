//Created class Named HarshadNumber
import java.util.Scanner;
public class HarshadNumber{
   public static void main(String[]args){

    //take input from the user
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();

    int sum=0;
    int originalNumber=number;

    //use while loop to calculate sum of digits
    while(originalNumber!=0){
        int digit=originalNumber%10;
        sum=sum+digit;
        originalNumber=originalNumber/10;
    }

    //check whether the number is a Harshad Number
    if(number%sum==0){
        System.out.println("Harshad Number");
    }
    else{
        System.out.println("Not a Harshad Number");
    }
   }
}
