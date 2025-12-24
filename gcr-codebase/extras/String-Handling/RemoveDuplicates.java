//created class named RemoveDuplicates
import java.util.Scanner;
public class RemoveDuplicates{
    public static void main(String[]args){
		
		//take text as input
        Scanner input=new Scanner(System.in);
        String text=input.next();
		String modified="";
		for(int i=0;i<text.length();i++){
			char ch=text.charAt(i);
			boolean Duplicate=false;
			
			for(int j=0;j<modified.length();j++){
				if(modified.charAt(j)==ch){
					Duplicate=true;
					break;
				}
			}
			if(!Duplicate){
				modified+=ch;
			}
			
		}
		//display the modified String with no duplicates
		System.out.println(modified);
   }
}