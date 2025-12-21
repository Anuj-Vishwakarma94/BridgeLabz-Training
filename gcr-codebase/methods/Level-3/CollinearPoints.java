//Created class Named CollinearPoints
import java.util.Scanner;
public class CollinearPoints{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input for three points
    double x1=input.nextDouble();
    double y1=input.nextDouble();
    double x2=input.nextDouble();
    double y2=input.nextDouble();
    double x3=input.nextDouble();
    double y3=input.nextDouble();

    //check collinearity using slope method
    if(isCollinearUsingSlope(x1,y1,x2,y2,x3,y3)){
        System.out.println("Points are Collinear using Slope Method");
    }
    else{
        System.out.println("Points are NOT Collinear using Slope Method");
    }

    //check collinearity using area method
    if(isCollinearUsingArea(x1,y1,x2,y2,x3,y3)){
        System.out.println("Points are Collinear using Area Method");
    }
    else{
        System.out.println("Points are NOT Collinear using Area Method");
    }
   }

   //method to check collinearity using slope formula
   public static boolean isCollinearUsingSlope(double x1,double y1,double x2,double y2,double x3,double y3){

       double slopeAB=(y2-y1)/(x2-x1);
       double slopeBC=(y3-y2)/(x3-x2);
       double slopeAC=(y3-y1)/(x3-x1);

       if(slopeAB==slopeBC && slopeBC==slopeAC){
           return true;
       }
       else{
           return false;
       }
   }

   //method to check collinearity using area of triangle formula
   public static boolean isCollinearUsingArea(double x1,double y1,double x2,double y2,double x3,double y3){
       double area=0.5*(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2));

       if(area==0){
           return true;
       }
       else{
           return false;
       }
   }
}
