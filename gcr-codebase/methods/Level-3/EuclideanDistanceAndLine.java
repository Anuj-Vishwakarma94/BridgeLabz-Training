//Created class Named EuclideanDistanceAndLine
import java.util.Scanner;
public class EuclideanDistanceAndLine{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input for two points
    double x1=input.nextDouble();
    double y1=input.nextDouble();
    double x2=input.nextDouble();
    double y2=input.nextDouble();

    double distance=findEuclideanDistance(x1,y1,x2,y2);
    double lineData[]=findLineEquation(x1,y1,x2,y2);

    //display results
    System.out.println("Euclidean Distance = " + distance);
    System.out.println("Slope (m) = " + lineData[0]);
    System.out.println("Y-Intercept (b) = " + lineData[1]);
    System.out.println("Equation of Line : y = " + lineData[0] + " * x + " + lineData[1]);
   }

   //method to find euclidean distance
   public static double findEuclideanDistance(double x1,double y1,double x2,double y2){
       double distance=Math.sqrt(Math.pow(x2-x1,2)+Math.pow(y2-y1,2));
       return distance;
   }

   //method to find equation of line (slope and intercept)
   public static double[] findLineEquation(double x1,double y1,double x2,double y2){
       double m=(y2-y1)/(x2-x1);
       double b=y1-(m*x1);

       return new double[]{m,b};
   }
}
