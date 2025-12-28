//Program to convert string to lowercase
import java.util.Scanner;

public class ToLowerCaseString {

   public String toLowerCase(String s){
      return s.toLowerCase();
   }

   public static void main(String[] args){

      Scanner input = new Scanner(System.in);

      String s = input.nextLine();

      ToLowerCaseString obj = new ToLowerCaseString();

      String result = obj.toLowerCase(s);

      System.out.println(result);
   }
}
