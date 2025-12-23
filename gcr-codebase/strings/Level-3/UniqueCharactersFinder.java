//Created class Named UniqueCharactersFinder
import java.util.Scanner;
public class UniqueCharactersFinder{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take complete text input
    String text=input.nextLine();
    char uniqueChars[]=findUniqueCharacters(text);

    //display unique characters
    System.out.print("Unique Characters : ");
    for(int i=0;i<uniqueChars.length;i++){
        System.out.print(uniqueChars[i] + " ");
    }
   }

   //method to find length without using length()
   public static int findLengthWithoutLength(String text){
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

   //method to find unique characters using charAt()
   public static char[] findUniqueCharacters(String text){
       int length=findLengthWithoutLength(text);

       //temporary array to store unique characters
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

       //create final array with exact size
       char result[]=new char[index];
       for(int i=0;i<index;i++){
           result[i]=temp[i];
       }

       return result;
   }
}
