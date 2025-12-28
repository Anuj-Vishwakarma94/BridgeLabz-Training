//Program to return first palindromic string
import java.util.Scanner;

public class FirstPalindrome {

   public String firstPalindrome(String words[]){

      for(String s : words){

         int left = 0;
         int right = s.length() - 1;
         boolean isPal = true;

         while(left < right){
            if(s.charAt(left) != s.charAt(right)){
               isPal = false;
               break;
            }
            left++;
            right--;
         }

         if(isPal){
            return s;
         }
      }
      return "";
   }

   public static void main(String[] args){

      Scanner input = new Scanner(System.in);

      int n = input.nextInt();
      input.nextLine();

      String words[] = new String[n];

      for(int i = 0; i < n; i++){
         words[i] = input.nextLine();
      }

      FirstPalindrome obj = new FirstPalindrome();

      String result = obj.firstPalindrome(words);

      System.out.println(result);
   }
}
