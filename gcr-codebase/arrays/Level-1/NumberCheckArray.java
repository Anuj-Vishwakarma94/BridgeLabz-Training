//Created class Named NumberCheckArray
import java.util.Scanner;
public class NumberCheckArray{
   public static void main(String[]args){

    //take input for 5 numbers
    Scanner input=new Scanner(System.in);
    int numbers[]=new int[5];

    for(int i=0;i<numbers.length;i++){
        numbers[i]=input.nextInt();
    }

    //check each number in the array
    for(int i=0;i<numbers.length;i++){
        if(numbers[i]>0){
            if(numbers[i]%2==0){
                System.out.println(numbers[i] + " is Positive Even");
            }
            else{
                System.out.println(numbers[i] + " is Positive Odd");
            }
        }
        else if(numbers[i]<0){
            System.out.println(numbers[i] + " is Negative");
        }
        else{
            System.out.println(numbers[i] + " is Zero");
        }
    }

    //compare first and last elements of the array and then print the output
    if(numbers[0]==numbers[numbers.length-1]){
        System.out.println("First and last elements are equal");
    }
    else if(numbers[0]>numbers[numbers.length-1]){
        System.out.println("First element is greater than last element");
    }
    else{
        System.out.println("First element is less than last element");
    }
   }
}
