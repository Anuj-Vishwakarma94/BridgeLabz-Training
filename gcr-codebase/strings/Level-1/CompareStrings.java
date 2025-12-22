//created class named CompareStrings
import java.util.Scanner;
public class CompareStrings{
    public static void main(String[]args){
	    Scanner input=new Scanner(System.in);
		
		//take String one and String two as input
		String one=input.next();
		String two=input.next();
		
		//display if the two Strings are equal or not using String Built-In method
		if(one.equals(two)){
			System.out.println(true);
		}
		else{
		    System.out.println(false);
		}
		
	//compare strings using charAt method
	boolean charAtResult=compareStringsUsingCharAt(one,two);
	System.out.println(charAtResult);
    }	
    
	//method to compare two strings using charAt()
	public static boolean compareStringsUsingCharAt(String one,String two){
	    if(one.length()!=two.length()){
            return false;
        }
		else{
            for(int i=0;i<one.length();i++){
                if(one.charAt(i)!=two.charAt(i)){
                    return false;
                }
            }
			return true;
		}
   }
}