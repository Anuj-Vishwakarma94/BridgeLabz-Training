//Program to check three consecutive odd numbers
import java.util.Scanner;

public class ThreeConsecutiveOdds {

   public boolean threeConsecutiveOdds(int arr[]){

      int count = 0;

      for(int n : arr){
         if(n % 2 != 0){
            count++;
            if(count == 3){
               return true;
            }
         } else {
            count = 0;
         }
      }
      return false;
   }

   public static void main(String[] args){

      Scanner input = new Scanner(System.in);

      int n = input.nextInt();
      int arr[] = new int[n];

      for(int i = 0; i < n; i++){
         arr[i] = input.nextInt();
      }

      ThreeConsecutiveOdds obj = new ThreeConsecutiveOdds();

      boolean result = obj.threeConsecutiveOdds(arr);

      System.out.println(result);
   }
}
