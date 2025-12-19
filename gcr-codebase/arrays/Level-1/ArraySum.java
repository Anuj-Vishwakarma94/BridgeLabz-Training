//Created class Named ArraySum
import java.util.Scanner;
public class ArraySum{
   public static void main(String[]args){

    //create array, total and index
    Scanner input=new Scanner(System.in);
    double numbers[]=new double[10];
    double total=0.0;
    int index=0;

    //use infinite while loop to take input
    while(true){
        double value=input.nextDouble();
        if(value<=0){
            break;
        }
        if(index==10){
            break;
        }
        numbers[index]=value;
        index++;
    }

    //use for loop to display values and calculate total
    for(int i=0;i<index;i++){
        System.out.println(numbers[i]);
        total=total+numbers[i];
    }

    //display the total value
    System.out.println(total);
   }
}
