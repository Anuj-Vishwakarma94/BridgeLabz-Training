//Created class Named AbundantNumber
import java.util.Scanner;
public class AbundantNumber{
   public static void main(String[]args){

    //take input from the user
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();

    int sum=0;

    //use for loop to find sum of divisors
    for(int i=1;i<number;i++){
        if(number%i==0){
            sum=sum+i;
        }
    }

    //check whether the number is an Abundant Number
    if(sum>number){
        System.out.println("Abundant Number");
    }
    else{
        System.out.println("Not an Abundant Number");
    }
   }
}
