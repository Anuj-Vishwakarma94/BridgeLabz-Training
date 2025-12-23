//Created class Named CharacterFrequencies
import java.util.Scanner;
public class CharacterFrequencies{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take complete text input
    String text=input.nextLine();
    String result[][]=findCharacterFrequency(text);

    //display result
    displayFrequency(result);
   }

   //method to find character frequency using charAt()
   public static String[][] findCharacterFrequency(String text){
       int freq[]=new int[256];

       for(int i=0;i<text.length();i++){
           char ch=text.charAt(i);
           freq[ch]++;
       }

       int count=0;
       for(int i=0;i<text.length();i++){
           char ch=text.charAt(i);
           if(freq[ch]>0){
               count++;
               freq[ch]=0; 
           }
       }

       for(int i=0;i<text.length();i++){
           char ch=text.charAt(i);
           freq[ch]++;
       }

       String table[][]=new String[count][2];
       int index=0;
       for(int i=0;i<text.length();i++){
           char ch=text.charAt(i);

           if(freq[ch]>0){
               table[index][0]=String.valueOf(ch);
               table[index][1]=String.valueOf(freq[ch]);
               index++;
               freq[ch]=0; 
           }
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
