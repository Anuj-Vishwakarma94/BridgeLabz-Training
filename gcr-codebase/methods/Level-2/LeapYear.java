//Created class Named LeapYear
import java.util.Scanner;
public class LeapYear{
   public static void main(String[]args){

    //take input for the year
    Scanner input=new Scanner(System.in);
    int year=input.nextInt();

    if(year<1582){
        System.out.println("Year is not valid for Leap Year calculation");
    }
    else{
        boolean result=isLeapYear(year);

        if(result){
            System.out.println("Year is a Leap Year");
        }
        else{
            System.out.println("Year is not a Leap Year");
        }
    }
   }

   //method to check leap year
   public static boolean isLeapYear(int year){
       if((year%4==0 && year%100!=0) || (year%400==0)){
           return true;
       }
       else{
           return false;
       }
   }
}
