//Created class Named StringSplitComparison
import java.util.Scanner;
public class StringSplitComparison{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take complete text input
    String text=input.nextLine();

    //split text using user-defined method
    String userWords[]=splitTextUsingCharAt(text);

    //split text using built-in split() method
    String builtInWords[]=text.split(" ");

    //compare both string arrays
    boolean result=compareStringArrays(userWords,builtInWords);

    //display result
    System.out.println("Comparison Result = " + result);

    if(result){
        System.out.println("Both methods produce the same words");
    }
    else{
        System.out.println("Both methods produce different words");
    }
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

       //extract words using indexes
       for(int i=0;i<wordCount;i++){
           String word="";
           for(int j=spaceIndex[i]+1;j<spaceIndex[i+1];j++){
               word=word+text.charAt(j);
           }
           words[i]=word;
       }
       return words;
   }

   //method to compare two string arrays
   public static boolean compareStringArrays(String arr1[],String arr2[]){
       if(arr1.length!=arr2.length){
           return false;
       }

       for(int i=0;i<arr1.length;i++){
           if(!arr1[i].equals(arr2[i])){
               return false;
           }
       }
       return true;
   }
}