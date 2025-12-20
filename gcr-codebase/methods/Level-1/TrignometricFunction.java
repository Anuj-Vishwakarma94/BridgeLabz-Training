//Created class Named TrignometricFunction
import java.util.Scanner;
public class TrignometricFunction{
   public static void main(String[]args){

    //take input for angle
    Scanner input=new Scanner(System.in);
    double angle=input.nextDouble();
    double[] result=calculateTrignometricFunction(angle);

    //print the sine, cosine and tangent
    System.out.println(result[0]);
    System.out.println(result[1]);
    System.out.println(result[2]);   
    }

   //method to calculate radians,sine, cosine and tangent  
   public static double[] calculateTrignometricFunction(double angle){
       double radian=Math.toRadians(angle);
       double sin=Math.sin(radian);
       double cos=Math.cos(radian);
       double tan=Math.tan(radian);
       return new double[]{sin,cos,tan};
   }
}
