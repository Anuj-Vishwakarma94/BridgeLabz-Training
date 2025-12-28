//Program to find sum of multiples of 3, 5, or 7
import java.util.Scanner;

public class SumOfMultiples {

   public int sumOfMultiples(int n){

      int sum = 0;

      for(int i = 1; i <= n; i++){
         if(i % 3 == 0 || i % 5 == 0 || i % 7 == 0){
            sum += i;
         }
      }
      return sum;
   }

   public static void main(String[] args){

      Scanner input = new Scanner(System.in);

      int n = input.nextInt();

      SumOfMultiples obj = new SumOfMultiples();

      int result = obj.sumOfMultiples(n);

      System.out.println(result);
   }
}
