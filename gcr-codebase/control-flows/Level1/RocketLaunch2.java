//Created class Named RocketLaunch2
import java.util.Scanner;
public class RocketLaunch2{
    public static void main(String[]args){
	
	//take counter as input from the user and use for loop to process the countdown	
	Scanner input=new Scanner(System.in);
	int counter=input.nextInt();
	for(int i=counter;i>0;i--){
	    
	    //print the countdown for rocket launch
		System.out.println(i);
	    }
	}
}	