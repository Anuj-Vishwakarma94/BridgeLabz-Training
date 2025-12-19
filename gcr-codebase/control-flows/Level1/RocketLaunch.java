//Created class Named RocketLaunch
import java.util.Scanner;
public class RocketLaunch{
    public static void main(String[]args){
	
	//take counter as input from the user and use while loop to process the countdown	
	Scanner input=new Scanner(System.in);
	int counter=input.nextInt();
	System.out.println(counter);
	while(counter>1){
	    counter--;
	    
	    //print the countdown for rocket launch
		System.out.println(counter);
	    }
	}
}	