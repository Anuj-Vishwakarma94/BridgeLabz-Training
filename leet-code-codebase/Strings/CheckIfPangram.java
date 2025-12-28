//Program to check if a sentence is pangram
import java.util.Scanner;

public class CheckIfPangram {

   public boolean checkIfPangram(String sentence){

      boolean A[] = new boolean[26];

      for(int i = 0; i < sentence.length(); i++){
         char c = sentence.charAt(i);
         A[c - 'a'] = true;
      }

      //check if all letters present
      for(boolean val : A){
         if(!val){
            return false;
         }
      }
      return true;
   }

   public static void main(String[] args){

      Scanner input = new Scanner(System.in);

      String sentence = input.nextLine();

      CheckIfPangram obj = new CheckIfPangram();

      boolean result = obj.checkIfPangram(sentence);

      System.out.println(result);
   }
}
