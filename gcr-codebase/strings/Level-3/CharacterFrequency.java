//Created class Named CharacterFrequency
import java.util.Scanner;
public class CharacterFrequency{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take complete text input
    String text=input.nextLine();

    String result[]=findCharacterFrequency(text);

    //display the result
    System.out.println("Character\tFrequency");
    for(int i=0;i<result.length;i++){
        if(result[i]!=null){
            System.out.println(result[i]);
        }
    }
   }

   //method to find frequency of characters using nested loops
   public static String[] findCharacterFrequency(String text){

       char characters[]=text.toCharArray();
       int frequency[]=new int[characters.length];

       for(int i=0;i<frequency.length;i++){
           frequency[i]=1;
       }

       for(int i=0;i<characters.length;i++){
           if(characters[i]=='0'){
               continue;
           }

           for(int j=i+1;j<characters.length;j++){
               if(characters[i]==characters[j]){
                   frequency[i]++;
                   characters[j]='0'; 
               }
           }
       }
       String result[]=new String[characters.length];
       int index=0;
       for(int i=0;i<characters.length;i++){
           if(characters[i]!='0'){
               result[index]=characters[i] + "\t\t" + frequency[i];
               index++;
           }
       }

       return result;
   }
}
