//Created class Named LongestWord
import java.util.Scanner;
public class LongestWord{
   public static void main(String[]args){
    Scanner input=new Scanner(System.in);

    //take input sentence
    String sentence=input.nextLine();
    String longestWord=findLongestWord(sentence);

    //display result
    System.out.println("Longest Word: " + longestWord);
   }

   //method to find longest word
   public static String findLongestWord(String sentence){
       String word="";
       String longest="";
       for(int i=0;i<sentence.length();i++){
           char ch=sentence.charAt(i);
           if(ch!=' '){
               word=word+ch;
           }
           else{
               if(word.length()>longest.length()){
                   longest=word;
               }
               word="";
           }
       }
       if(word.length()>longest.length()){
           longest=word;
       }
       return longest;
   }
}
