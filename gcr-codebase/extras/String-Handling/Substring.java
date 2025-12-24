//Created class Named Substring
import java.util.Scanner;
public class Substring{
   public static void main(String[]args){
    Scanner input=new Scanner(System.in);

    //take main text input
    String text=input.nextLine();

    //take substring input
    String sub=input.nextLine();
    int count=countOccurrences(text,sub);

    //display result
    System.out.println("Occurrences : " + count);
   }

   //method to count substring occurrences
   public static int countOccurrences(String text,String sub){
       int count=0;
       for(int i=0;i<=text.length()-sub.length();i++){
           boolean match=true;
           for(int j=0;j<sub.length();j++){
               if(text.charAt(i+j)!=sub.charAt(j)){
                   match=false;
                   break;
               }
           }
           if(match){
               count++;
           }
       }
       return count;
   }
}
