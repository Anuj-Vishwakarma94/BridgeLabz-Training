//Program to count digits that divide the number
import java.util.Scanner;

public class CountDigits {

   public int countDigits(int num){

      int count = 0;
      int temp = num;

      while(temp > 0){
         int digit = temp % 10;
         if(num % digit == 0){
            count++;
         }
         temp /= 10;
      }
      return count;
   }

   public static void main(String[] args){

      Scanner input = new Scanner(System.in);

      int num = input.nextInt();

      CountDigits obj = new CountDigits();

      int result = obj.countDigits(num);

      System.out.println(result);
   }
}
