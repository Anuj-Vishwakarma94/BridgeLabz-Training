//Program to find difference between element sum and digit sum
import java.util.Scanner;

public class DifferenceOfSum {

   public int differenceOfSum(int nums[]){

      int elementSum = 0;
      int digitSum = 0;

      for(int num : nums){

         elementSum += num;

         int temp = num;
         while(temp > 0){
            digitSum += temp % 10;
            temp /= 10;
         }
      }

      return Math.abs(elementSum - digitSum);
   }

   public static void main(String[] args){

      Scanner input = new Scanner(System.in);

      int n = input.nextInt();
      int nums[] = new int[n];

      for(int i = 0; i < n; i++){
         nums[i] = input.nextInt();
      }

      DifferenceOfSum obj = new DifferenceOfSum();

      int result = obj.differenceOfSum(nums);

      System.out.println(result);
   }
}
