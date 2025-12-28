//Program to find maximum words in a sentence
import java.util.Scanner;

public class MostWordsFound {

   public int mostWordsFound(String sentences[]){

      int count = 0;

      for(String s : sentences){

         int spaces = 0;

         for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == ' '){
               spaces++;
            }
         }

         int words = spaces + 1;
         count = Math.max(count, words);
      }

      return count;
   }

   public static void main(String[] args){

      Scanner input = new Scanner(System.in);

      int n = input.nextInt();
      input.nextLine();   //consume newline

      String sentences[] = new String[n];

      for(int i = 0; i < n; i++){
         sentences[i] = input.nextLine();
      }

      MostWordsFound obj = new MostWordsFound();

      int result = obj.mostWordsFound(sentences);

      System.out.println(result);
   }
}
