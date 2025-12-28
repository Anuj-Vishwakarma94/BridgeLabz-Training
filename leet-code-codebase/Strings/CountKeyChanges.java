//Program to count key changes in a string
import java.util.Scanner;

public class CountKeyChanges {

   public int countKeyChanges(String s){

      s = s.toLowerCase();
      int changes = 0;

      for(int i = 1; i < s.length(); i++){
         if(s.charAt(i) != s.charAt(i - 1)){
            changes++;
         }
      }
      return changes;
   }

   public static void main(String[] args){

      Scanner input = new Scanner(System.in);

      String s = input.nextLine();

      CountKeyChanges obj = new CountKeyChanges();

      int result = obj.countKeyChanges(s);

      System.out.println(result);
   }
}
