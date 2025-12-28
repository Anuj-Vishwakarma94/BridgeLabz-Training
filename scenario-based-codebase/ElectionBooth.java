//created class named ElectionBooth
import java.util.Scanner;
public class ElectionBooth {
    public static void main(String[] args){
        Scanner input=new Scanner(System.in);
        while(true){
            int age=input.nextInt();
            if(age == 0)
                break;

            if(age < 18){
                System.out.println("Not Eligible");
                continue;
            }
			
            //display result
            int vote=input.nextInt();
            if(vote == 1 || vote == 2 || vote == 3){
                System.out.println("Vote Recorded");
            }
			else{
                System.out.println("Invalid Vote");
            }
		}
    }
}

 