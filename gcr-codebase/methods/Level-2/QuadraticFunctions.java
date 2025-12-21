//Created class Named QuadraticFunctions
import java.util.Scanner;
public class QuadraticFunctions{
   public static void main(String[]args){

    //take input for a, b and c
    Scanner input=new Scanner(System.in);
    double a=input.nextDouble();
    double b=input.nextDouble();
    double c=input.nextDouble();

    double roots[]=findRoots(a,b,c);

    //display the roots
    if(roots.length==2){
        System.out.println("Root 1 = " + roots[0]);
        System.out.println("Root 2 = " + roots[1]);
    }
    else if(roots.length==1){
        System.out.println("Root = " + roots[0]);
    }
    else{
        System.out.println("No real roots");
    }
   }

   //method to find roots of quadratic equation
   public static double[] findRoots(double a,double b,double c){
       double delta=Math.pow(b,2)-(4*a*c);

       if(delta>0){
           double root1=(-b+Math.sqrt(delta))/(2*a);
           double root2=(-b-Math.sqrt(delta))/(2*a);
           return new double[]{root1,root2};
       }
       else if(delta==0){
           double root=-b/(2*a);
           return new double[]{root};
       }
       else{
           return new double[0];
       }
   }
}
