//Created class Named AnagramChecker
import java.util.Scanner;
public class AnagramChecker{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input for two texts
    String text1=input.nextLine();
    String text2=input.nextLine();
    boolean result=checkAnagram(text1,text2);

    //display result
    if(result){
        System.out.println("The given texts are Anagrams");
    }
    else{
        System.out.println("The given texts are NOT Anagrams");
    }
   }

   //method to check if two texts are anagrams
   public static boolean checkAnagram(String text1,String text2){

       text1=text1.replace(" ","").toLowerCase();
       text2=text2.replace(" ","").toLowerCase();

       if(text1.length()!=text2.length()){
           return false;
       }

       int freq1[]=new int[256];
       int freq2[]=new int[256];

       for(int i=0;i<text1.length();i++){
           char ch=text1.charAt(i);
           freq1[ch]++;
       }

       for(int i=0;i<text2.length();i++){
           char ch=text2.charAt(i);
           freq2[ch]++;
       }

       for(int i=0;i<256;i++){
           if(freq1[i]!=freq2[i]){
               return false;
           }
       }

       return true;
   }
}
