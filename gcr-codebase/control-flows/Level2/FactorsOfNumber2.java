//Created class Named FactorsOfNumber2
import java.util.Scanner2;
public class FactorsOfNumber{
   public static void main(String[]args){

    //take input from the user and check whether it is a positive integer
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();

    if(number<=0){
        System.out.println("Please enter a positive integer");
    }
    else{
        int i=1;

        //use while loop to find factors of the number
        while(i<number){
            if(number%i==0){
                System.out.println(i);
            }
            i++;
        }
    }
   }
}
