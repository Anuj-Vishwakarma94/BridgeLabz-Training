//Created class Named SpringSeason
public class SpringSeason{
   public static void main(String[]args){
 
    //take month and days as the input from the user and check whether it is a spring season or not
    int month=Integer.parseInt(args[0]);
    int days=Integer.parseInt(args[1]);
	boolean check=false;
    if(month == 3 && days >= 20 && days <= 31 || month == 4 && days >= 1 && days <= 30 || month == 5 && days >= 1 && days <= 31 || month == 6 && days >= 1 && days <= 20){
        check=true;
        }
	else{
        check=false;
		}

    //print whether it is spring Season or not 
	if(check==true){
		System.out.println("It's a Spring Season");
		}
	else{
        System.out.println("Not a Spring Season");	
		}
	}
}