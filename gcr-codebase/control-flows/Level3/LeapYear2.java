//Created class Named LeapYear2
import java.util.Scanner;
public class LeapYear2{
   public static void main(String[]args){

    //take year as input from the user and check whether the year is valid
    Scanner input=new Scanner(System.in);
    int year=input.nextInt();

    if(year<1582){
        System.out.println("Year is not valid for Leap Year calculation");
    }
    else{

        //use single if condition with logical operators to check whether it is a leap year or not
        if((year%4==0 && year%100!=0) || (year%400==0)){
            System.out.println("Year is a Leap Year");
        }
        else{
            System.out.println("Year is not a Leap Year");
        }
    }
   }
}
