//Created class Named TwoDArray
import java.util.Scanner;
public class TwoDArray{
   public static void main(String[]args){

    //take input for rows and columns
    Scanner input=new Scanner(System.in);
    int rows=input.nextInt();
    int columns=input.nextInt();

    int matrix[][]=new int[rows][columns];

    //take input for 2D array elements
    for(int i=0;i<rows;i++){
        for(int j=0;j<columns;j++){
            matrix[i][j]=input.nextInt();
        }
    }

    int array[]=new int[rows*columns];
    int index=0;

    //copy 2D array elements into 1D array
    for(int i=0;i<rows;i++){
        for(int j=0;j<columns;j++){
            array[index]=matrix[i][j];
            index++;
        }
    }

    //print the 1D array elements
    for(int i=0;i<array.length;i++){
        System.out.println(array[i]);
    }
   }
}
