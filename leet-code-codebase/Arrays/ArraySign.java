//Program to find sign of product of array
import java.util.Scanner;

public class ArraySign {

   public int arraySign(int nums[]){

      int negCount = 0;

      for(int n : nums){
         if(n == 0){
            return 0;
         }
         if(n < 0){
            negCount++;
         }
      }

      return (negCount % 2 == 0) ? 1 : -1;
   }

   public static void main(String[] args){

      Scanner input = new Scanner(System.in);

      int n = input.nextInt();
      int nums[] = new int[n];

      for(int i = 0; i < n; i++){
         nums[i] = input.nextInt();
      }

      ArraySign obj = new ArraySign();

      int result = obj.arraySign(nums);

      System.out.println(result);
   }
}
