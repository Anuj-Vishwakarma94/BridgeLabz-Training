//Program to find maximum wealth among customers
import java.util.Scanner;

public class MaximumWealth {

   public int maximumWealth(int accounts[][]){

      int max = 0;

      for(int i = 0; i < accounts.length; i++){

         int sum = 0;

         for(int j = 0; j < accounts[i].length; j++){
            sum += accounts[i][j];
         }

         if(sum > max){
            max = sum;
         }
      }
      return max;
   }

   public static void main(String[] args){

      Scanner input = new Scanner(System.in);

      int m = input.nextInt();
      int n = input.nextInt();

      int accounts[][] = new int[m][n];

      for(int i = 0; i < m; i++){
         for(int j = 0; j < n; j++){
            accounts[i][j] = input.nextInt();
         }
      }

      MaximumWealth obj = new MaximumWealth();

      int result = obj.maximumWealth(accounts);

      System.out.println(result);
   }
}
