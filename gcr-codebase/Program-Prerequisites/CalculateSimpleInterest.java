import java.util.*;
public class CalculateSimpleInterest{
    public static void main (String[]args){
        Scanner Sc=new Scanner(System.in);
		int Principal=Sc.nextInt();
		int Rate=Sc.nextInt();
		int Time=Sc.nextInt();
		int SimpleInterest=(Principal*Rate*Time)/100;
		System.out.println(SimpleInterest);
    }
}