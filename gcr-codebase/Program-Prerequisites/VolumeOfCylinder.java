import java.util.*;
public class VolumeOfCylinder{
    public static void main (String[]args){
        Scanner Sc=new Scanner(System.in);
		int Radius=Sc.nextInt();
		int Height=Sc.nextInt();
		int Volume=(22/7)*Radius*Radius*Height;
		System.out.println(Volume);
    }
}