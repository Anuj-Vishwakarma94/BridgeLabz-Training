import java.util.*;
public class ConvertKilometerToMiles{
    public static void main (String[]args){
        Scanner Sc=new Scanner(System.in);
		double Kilometer=Sc.nextInt();
		double Miles=Kilometer*0.621371;
		System.out.println(Miles);
    }
}