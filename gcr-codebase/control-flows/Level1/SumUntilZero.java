//Created class Named SumUntilZero
import java.util.Scanner;
public class SumUntilZero{
   public static void main(String[]args){

    //take input from the user and calculate the sum until user enters 0
    Scanner input=new Scanner(System.in);
    double total=0.0;
    double number=input.nextDouble();

    //use while loop to add numbers until 0 is entered
    while(number!=0){
        total=total+number;
        number=input.nextDouble();
    }
	
    //print the total sum
    System.out.println(total);
   }
}
