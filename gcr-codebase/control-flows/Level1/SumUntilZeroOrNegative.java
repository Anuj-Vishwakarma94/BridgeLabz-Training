//Created class Named SumUntilZeroOrNegative
import java.util.Scanner;
public class SumUntilZeroOrNegative{
   public static void main(String[]args){

    //take input from the user and calculate the sum until 0 or negative number is entered
    Scanner input=new Scanner(System.in);
    double total=0.0;

    //use infinite while loop and break when 0 or negative value is entered
    while(true){
        double number=input.nextDouble();
        if(number<=0){
            break;
        }
        total=total+number;
    }

    //print the total sum
    System.out.println(total);
   }
}
