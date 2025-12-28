//Program to perform xor operation on array values
import java.util.Scanner;

public class XorOperationInAnArray {

   public int xorOperation(int n, int start){

      int result = 0;

      for(int i = 0; i < n; i++){
         int value = start + 2 * i;
         result ^= value;
      }

      return result;
   }

   public static void main(String[] args){

      Scanner input = new Scanner(System.in);

      int n = input.nextInt();
      int start = input.nextInt();

      XorOperationInAnArray obj = new XorOperationInAnArray();

      int result = obj.xorOperation(n, start);

      System.out.println(result);
   }
}
