//Created class Named SpringSeason
public class SpringSeason{
   public static void main(String[]args){
 
    //take month and days as the input 
    int month=Integer.parseInt(args[0]);
    int days=Integer.parseInt(args[1]);
    

    //print whether it is spring Season or not 
	if(check(month,days)){
	System.out.println("It's a Spring Season");
	}
	else{
        System.out.println("Not a Spring Season");
        }
    }
    //method to check whether it is spring season or not
       public static boolean check(int month,int days){
       if(month == 3 && days >= 20 && days <= 31 || month == 4 && days >= 1 && days <= 30 || month == 5 && days >= 1 && days <= 31 || month == 6 && days >= 1 && days <= 20){
       return true;
       }
       else{
       return false;
       }
   }
}