//Program to count employees meeting target
import java.util.Scanner;

public class NumberOfEmployeesWhoMetTarget {

   public int numberOfEmployeesWhoMetTarget(int hours[], int target){

      int count = 0;

      for(int i : hours){
         if(i >= target){
            count++;
         }
      }
      return count;
   }

   public static void main(String[] args){

      Scanner input = new Scanner(System.in);

      int n = input.nextInt();
      int target = input.nextInt();

      int hours[] = new int[n];

      for(int i = 0; i < n; i++){
         hours[i] = input.nextInt();
      }

      NumberOfEmployeesWhoMetTarget obj = new NumberOfEmployeesWhoMetTarget();

      int result = obj.numberOfEmployeesWhoMetTarget(hours, target);

      System.out.println(result);
   }
}
