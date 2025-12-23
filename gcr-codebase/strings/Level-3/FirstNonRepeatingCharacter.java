//Created class Named FirstNonRepeatingCharacter
import java.util.Scanner;
public class FirstNonRepeatingCharacter{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take complete text input
    String text=input.nextLine();

    char result=findFirstNonRepeatingCharacter(text);

    //display result
    if(result!='\0'){
        System.out.println("First Non-Repeating Character : " + result);
    }
    else{
        System.out.println("No Non-Repeating Character Found");
    }
   }

   //method to find first non-repeating character using charAt()
   public static char findFirstNonRepeatingCharacter(String text){

       int frequency[]=new int[256];

       for(int i=0;i<text.length();i++){
           char ch=text.charAt(i);
           frequency[ch]++;
       }

       for(int i=0;i<text.length();i++){
           char ch=text.charAt(i);
           if(frequency[ch]==1){
               return ch;
           }
       }
       return '\0';
   }
}
