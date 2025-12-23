//Created class Named CharacterTypeFinder
import java.util.Scanner;
public class CharacterTypeFinder{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take complete text input
    String text=input.nextLine();

    //find character type for each character
    String result[][]=findCharacterTypes(text);

    //display result in tabular format
    displayCharacterTypes(result);
   }

   //method to check character type
   public static String checkCharacterType(char ch){

       //convert uppercase to lowercase using ASCII
       if(ch>='A' && ch<='Z'){
           ch=(char)(ch+32);
       }

       if(ch>='a' && ch<='z'){
           if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u'){
               return "Vowel";
           }
           else{
               return "Consonant";
           }
       }

       return "Not a Letter";
   }

   //method to find vowels and consonants using charAt()
   public static String[][] findCharacterTypes(String text){
       String table[][]=new String[text.length()][2];

       for(int i=0;i<text.length();i++){
           char ch=text.charAt(i);
           table[i][0]=String.valueOf(ch);
           table[i][1]=checkCharacterType(ch);
       }

       return table;
   }

   //method to display 2D array in tabular format
   public static void displayCharacterTypes(String table[][]){

       System.out.println("Character\tType");

       for(int i=0;i<table.length;i++){
           System.out.println(table[i][0] + "\t\t" + table[i][1]);
       }
   }
}
