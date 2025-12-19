//Created class Named EmployeeBonus
import java.util.Scanner;
public class EmployeeBonus{
   public static void main(String[]args){

    //take salary and years of service from the user
    Scanner input=new Scanner(System.in);
    double salary=input.nextDouble();
    int years=input.nextInt();

    if(years>5){
        double bonus=salary*0.05;
        System.out.println("Bonus amount is " + bonus);
    }
    else{
        System.out.println("No bonus applicable");
    }
   }
}
