//Created class Named ShortestAndLongestWord
import java.util.Scanner;
public class ShortestAndLongestWord{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take complete text input
    String text=input.nextLine();

    //split text into words using user-defined method
    String words[]=splitTextUsingCharAt(text);

    //create 2D array of words and their lengths
    String wordLengthTable[][]=createWordLengthTable(words);

    //find shortest and longest word indexes
    int result[]=findShortestAndLongest(wordLengthTable);

    //display results
    System.out.println("Shortest Word : " + wordLengthTable[result[0]][0]);
    System.out.println("Longest Word  : " + wordLengthTable[result[1]][0]);
   }

   //method to find string length without using length()
   public static int findLengthWithoutUsingLength(String text){
       int count=0;

       try{
           while(true){
               text.charAt(count);
               count++;
           }
       }
       catch(StringIndexOutOfBoundsException e){
       }

       return count;
   }

   //method to split text into words using charAt()
   public static String[] splitTextUsingCharAt(String text){
       int length=findLengthWithoutUsingLength(text);
       int wordCount=1;

       //count number of words
       for(int i=0;i<length;i++){
           if(text.charAt(i)==' '){
               wordCount++;
           }
       }

       int spaceIndex[]=new int[wordCount+1];
       spaceIndex[0]=-1;
       int index=1;

       //store indexes of spaces
       for(int i=0;i<length;i++){
           if(text.charAt(i)==' '){
               spaceIndex[index]=i;
               index++;
           }
       }
       spaceIndex[index]=length;

       String words[]=new String[wordCount];

       //extract words
       for(int i=0;i<wordCount;i++){
           String word="";
           for(int j=spaceIndex[i]+1;j<spaceIndex[i+1];j++){
               word=word+text.charAt(j);
           }
           words[i]=word;
       }

       return words;
   }

   //method to create 2D array of word and its length
   public static String[][] createWordLengthTable(String words[]){
       String table[][]=new String[words.length][2];

       for(int i=0;i<words.length;i++){
           int len=findLengthWithoutUsingLength(words[i]);
           table[i][0]=words[i];
           table[i][1]=String.valueOf(len);
       }

       return table;
   }

   //method to find shortest and longest word
   public static int[] findShortestAndLongest(String table[][]){
       int shortestIndex=0;
       int longestIndex=0;

       int shortestLength=Integer.parseInt(table[0][1]);
       int longestLength=Integer.parseInt(table[0][1]);

       for(int i=1;i<table.length;i++){
           int currentLength=Integer.parseInt(table[i][1]);

           if(currentLength<shortestLength){
               shortestLength=currentLength;
               shortestIndex=i;
           }

           if(currentLength>longestLength){
               longestLength=currentLength;
               longestIndex=i;
           }
       }

       return new int[]{shortestIndex,longestIndex};
   }
}