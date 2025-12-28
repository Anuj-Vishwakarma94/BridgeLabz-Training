//Program to find index of first unique character
import java.util.Scanner;

public class FirstUniqueCharacter{

   public int firstUniqChar(String s){

      int freq[] = new int[26];

      //count frequency
      for(int i = 0; i < s.length(); i++){
         freq[s.charAt(i) - 'a']++;
      }

      //find first unique
      for(int i = 0; i < s.length(); i++){
         if(freq[s.charAt(i) - 'a'] == 1){
            return i;
         }
      }

      return -1;
   }

   public static void main(String[] args){

      Scanner input = new Scanner(System.in);

      String s = input.nextLine();

      FirstUniqueCharacter obj = new FirstUniqueCharacter();

      int result = obj.firstUniqChar(s);

      System.out.println(result);
   }
}
