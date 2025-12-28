//Program to determine type of triangle
import java.util.Scanner;

public class TriangleType {

   public String triangleType(int nums[]){

      int a = nums[0], b = nums[1], c = nums[2];

      //check triangle validity
      if(a + b <= c || a + c <= b || b + c <= a){
         return "none";
      }

      if(a == b && b == c){
         return "equilateral";
      }

      if(a == b || a == c || b == c){
         return "isosceles";
      }

      return "scalene";
   }

   public static void main(String[] args){

      Scanner input = new Scanner(System.in);

      int nums[] = new int[3];

      for(int i = 0; i < 3; i++){
         nums[i] = input.nextInt();
      }

      TriangleType obj = new TriangleType();

      String result = obj.triangleType(nums);

      System.out.println(result);
   }
}
