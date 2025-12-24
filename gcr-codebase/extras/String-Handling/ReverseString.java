//created class named ReverseString
import java.util.Scanner;
public class ReverseString{
    public static void main(String[]args){
		
		//take text as input
        Scanner input=new Scanner(System.in);
        String text=input.next();
		String ReversedString="";
		for(int i=text.length()-1;i>=0;i--){
           ReversedString=ReversedString+text.charAt(i);
       }
		
		//display the Reversed String
		System.out.println("Reversed String : "+ReversedString);
   }
}