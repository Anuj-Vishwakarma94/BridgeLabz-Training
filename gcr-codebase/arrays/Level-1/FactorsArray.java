//Created class Named FactorsArray
import java.util.Scanner;
public class FactorsArray{
   public static void main(String[]args){

    //take input from the user
    Scanner input=new Scanner(System.in);
    int number=input.nextInt();

    int maxFactor=10;
    int factors[]=new int[maxFactor];
    int index=0;

    //use loop to find the factors
    for(int i=1;i<=number;i++){
        if(number%i==0){

            if(index==maxFactor){
                maxFactor=maxFactor*2;
                int temp[]=new int[maxFactor];

                for(int j=0;j<index;j++){
                    temp[j]=factors[j];
                }

                factors=temp;
            }

            factors[index]=i;
            index++;
        }
    }

    //print the factors of the number
    for(int i=0;i<index;i++){
        System.out.println(factors[i]);
    }
   }
}
