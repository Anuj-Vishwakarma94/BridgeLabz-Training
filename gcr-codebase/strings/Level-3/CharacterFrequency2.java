//Created class Named CharacterFrequency2
import java.util.Scanner;
public class CharacterFrequency2{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take complete text input
    String text=input.nextLine();

    char uniqueChars[]=findUniqueCharacters(text);
    String result[][]=findFrequencyUsingUnique(text,uniqueChars);

    //display result
    displayFrequency(result);
   }

   //method to find length without using length()
   public static int findLength(String text){
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

   //method to find unique characters using nested loops
   public static char[] findUniqueCharacters(String text){
       int length=findLength(text);
       char temp[]=new char[length];
       int index=0;

       for(int i=0;i<length;i++){
           char current=text.charAt(i);
           boolean isUnique=true;

           for(int j=0;j<i;j++){
               if(current==text.charAt(j)){
                   isUnique=false;
                   break;
               }
           }

           if(isUnique){
               temp[index]=current;
               index++;
           }
       }
       char unique[]=new char[index];
       for(int i=0;i<index;i++){
           unique[i]=temp[i];
       }

       return unique;
   }

   //method to find frequency using unique characters
   public static String[][] findFrequencyUsingUnique(String text,char unique[]){
       int freq[]=new int[256];

       for(int i=0;i<findLength(text);i++){
           freq[text.charAt(i)]++;
       }

       String table[][]=new String[unique.length][2];

       for(int i=0;i<unique.length;i++){
           table[i][0]=String.valueOf(unique[i]);
           table[i][1]=String.valueOf(freq[unique[i]]);
       }

       return table;
   }

   //method to display frequency in tabular format
   public static void displayFrequency(String table[][]){

       System.out.println("Character\tFrequency");

       for(int i=0;i<table.length;i++){
           System.out.println(table[i][0] + "\t\t" + table[i][1]);
       }
   }
}
