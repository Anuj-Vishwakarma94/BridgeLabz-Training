//created class named Palindrome
import java.util.Scanner;
public class Palindrome{
    public static void main(String[]args){
		
		//take text as input
        Scanner input=new Scanner(System.in);
        String text=input.next();
		boolean check=true;
		int start=0;
		int end=text.length()-1;
		while(start<end){
		    if(text.charAt(start)!=text.charAt(end)){
			    check=false;
			    break;
			}
			start++;
			end--;
		}
		
		//display if it is palindrome or not
		System.out.println(check);
   }
}