//Created class Named VowelConsonantCounter
import java.util.Scanner;
public class VowelConsonantCounter{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take complete text input
    String text=input.nextLine();

    //find count of vowels and consonants
    int result[]=findVowelsAndConsonants(text);

    //display result
    System.out.println("Vowel Count = " + result[0]);
    System.out.println("Consonant Count = " + result[1]);
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

   //method to find vowels and consonants in a string
   public static int[] findVowelsAndConsonants(String text){
       int vowels=0;
       int consonants=0;

       for(int i=0;i<text.length();i++){
           char ch=text.charAt(i);
           String type=checkCharacterType(ch);

           if(type.equals("Vowel")){
               vowels++;
           }
           else if(type.equals("Consonant")){
               consonants++;
           }
       }

       return new int[]{vowels,consonants};
   }
}
