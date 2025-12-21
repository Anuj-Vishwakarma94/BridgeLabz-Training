//Created class Named NumberAnalysis
import java.util.Scanner;
public class NumberAnalysis{
   public static void main(String[]args){

    //take input for 5 numbers
    Scanner input=new Scanner(System.in);
    int numbers[]=new int[5];

    for(int i=0;i<numbers.length;i++){
        numbers[i]=input.nextInt();
    }

    //check each number in the array
    for(int i=0;i<numbers.length;i++){
        if(isPositive(numbers[i])){
            if(isEven(numbers[i])){
                System.out.println(numbers[i] + " is Positive Even");
            }
            else{
                System.out.println(numbers[i] + " is Positive Odd");
            }
        }
        else{
            System.out.println(numbers[i] + " is Negative");
        }
    }

    //compare first and last elements of the array
    int result=compare(numbers[0],numbers[numbers.length-1]);

    if(result==1){
        System.out.println("First element is greater than last element");
    }
    else if(result==0){
        System.out.println("First and last elements are equal");
    }
    else{
        System.out.println("First element is less than last element");
    }
   }

   //method to check whether number is positive
   public static boolean isPositive(int number){
       if(number>=0){
           return true;
       }
       else{
           return false;
       }
   }

   //method to check whether number is even
   public static boolean isEven(int number){
       if(number%2==0){
           return true;
       }
       else{
           return false;
       }
   }

   //method to compare two numbers
   public static int compare(int number1,int number2){
       if(number1>number2){
           return 1;
       }
       else if(number1==number2){
           return 0;
       }
       else{
           return -1;
       }
   }
}
