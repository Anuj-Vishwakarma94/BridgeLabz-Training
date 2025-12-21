//Created class Named MatrixOperations
public class MatrixOperations{
   public static void main(String[]args){

    int rows1=2;
    int cols1=3;
    int rows2=3;
    int cols2=2;

    //create random matrices
    int matrixA[][]=createRandomMatrix(rows1,cols1);
    int matrixB[][]=createRandomMatrix(rows2,cols2);
    int matrixC[][]=createRandomMatrix(rows1,cols1);

    //display matrices
    System.out.println("Matrix A:");
    displayMatrix(matrixA);

    System.out.println("Matrix C:");
    displayMatrix(matrixC);

    //addition
    System.out.println("A + C:");
    displayMatrix(addMatrices(matrixA,matrixC));

    //subtraction
    System.out.println("A - C:");
    displayMatrix(subtractMatrices(matrixA,matrixC));

    System.out.println("Matrix B:");
    displayMatrix(matrixB);

    //multiplication
    System.out.println("A x B:");
    displayMatrix(multiplyMatrices(matrixA,matrixB));
   }

   //method to create random matrix
   public static int[][] createRandomMatrix(int rows,int cols){
       int matrix[][]=new int[rows][cols];

       for(int i=0;i<rows;i++){
           for(int j=0;j<cols;j++){
               matrix[i][j]=(int)(Math.random()*9)+1;
           }
       }

       return matrix;
   }

   //method to add two matrices
   public static int[][] addMatrices(int a[][],int b[][]){
       int result[][]=new int[a.length][a[0].length];

       for(int i=0;i<a.length;i++){
           for(int j=0;j<a[0].length;j++){
               result[i][j]=a[i][j]+b[i][j];
           }
       }

       return result;
   }

   //method to subtract two matrices
   public static int[][] subtractMatrices(int a[][],int b[][]){
       int result[][]=new int[a.length][a[0].length];

       for(int i=0;i<a.length;i++){
           for(int j=0;j<a[0].length;j++){
               result[i][j]=a[i][j]-b[i][j];
           }
       }

       return result;
   }

   //method to multiply two matrices
   public static int[][] multiplyMatrices(int a[][],int b[][]){
       int result[][]=new int[a.length][b[0].length];

       for(int i=0;i<a.length;i++){
           for(int j=0;j<b[0].length;j++){
               for(int k=0;k<a[0].length;k++){
                   result[i][j]=result[i][j]+(a[i][k]*b[k][j]);
               }
           }
       }

       return result;
   }

   //method to display matrix
   public static void displayMatrix(int matrix[][]){
       for(int i=0;i<matrix.length;i++){
           for(int j=0;j<matrix[0].length;j++){
               System.out.print(matrix[i][j] + " ");
           }
           System.out.println();
       }
       System.out.println();
   }
}
