//Program to rearrange numbers for number game
import java.util.Scanner;
import java.util.Arrays;

public class NumberGame {

   public int[] numberGame(int[] nums) {

      Arrays.sort(nums);
      int n = nums.length;
      int arr[] = new int[n];
      int k = 0;

      //swap each sorted pair
      for(int i = 0; i < n; i += 2){
         int alice = nums[i];
         int bob = nums[i + 1];
         arr[k++] = bob;
         arr[k++] = alice;
      }
      return arr;
   }

   public static void main(String[] args){

      Scanner input = new Scanner(System.in);

      int n = input.nextInt();
      int nums[] = new int[n];

      for(int i = 0; i < n; i++){
         nums[i] = input.nextInt();
      }

      NumberGame obj = new NumberGame();
      int result[] = obj.numberGame(nums);

      for(int x : result){
         System.out.print(x + " ");
      }
   }
}
