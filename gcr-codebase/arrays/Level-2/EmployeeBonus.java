//Created class Named EmployeeBonus
import java.util.Scanner;
public class EmployeeBonus{
   public static void main(String[]args){

    //define arrays and variables
    Scanner input=new Scanner(System.in);
    double salary[]=new double[10];
    double years[]=new double[10];
    double bonus[]=new double[10];
    double newSalary[]=new double[10];

    double totalBonus=0.0;
    double totalOldSalary=0.0;
    double totalNewSalary=0.0;

    //take input for salary and years of service
    for(int i=0;i<10;i++){
        double s=input.nextDouble();
        double y=input.nextDouble();

        if(s<=0 || y<0){
            System.out.println("Invalid input, enter again");
            i--;
        }
        else{
            salary[i]=s;
            years[i]=y;
        }
    }

    //calculate bonus, new salary and totals
    for(int i=0;i<10;i++){
        if(years[i]>5){
            bonus[i]=salary[i]*0.05;
        }
        else{
            bonus[i]=salary[i]*0.02;
        }

        newSalary[i]=salary[i]+bonus[i];

        totalBonus=totalBonus+bonus[i];
        totalOldSalary=totalOldSalary+salary[i];
        totalNewSalary=totalNewSalary+newSalary[i];
    }

    //print total bonus and salary details
    System.out.println("Total Bonus Amount = " + totalBonus);
    System.out.println("Total Old Salary = " + totalOldSalary);
    System.out.println("Total New Salary = " + totalNewSalary);
   }
}
