//Created class Named RandomNumber
public class RandomNumber{
   public static void main(String[]args){

    RandomNumber obj=new RandomNumber();

    int numbers[]=obj.generate4DigitRandomArray(5);

    //display generated random numbers
    for(int i=0;i<numbers.length;i++){
        System.out.println(numbers[i]);
    }

    double result[]=obj.findAverageMinMax(numbers);

    //display average, minimum and maximum
    System.out.println("Average = " + result[0]);
    System.out.println("Minimum = " + result[1]);
    System.out.println("Maximum = " + result[2]);
   }

   //method to generate array of 4 digit random numbers
   public int[] generate4DigitRandomArray(int size){
       int arr[]=new int[size];

       for(int i=0;i<size;i++){
           arr[i]=(int)(Math.random()*9000)+1000;
       }

       return arr;
   }

   //method to find average, minimum and maximum
   public double[] findAverageMinMax(int[] numbers){
       int min=numbers[0];
       int max=numbers[0];
       int sum=0;

       for(int i=0;i<numbers.length;i++){
           sum=sum+numbers[i];
           min=Math.min(min,numbers[i]);
           max=Math.max(max,numbers[i]);
       }

       double average=(double)sum/numbers.length;

       return new double[]{average,min,max};
   }
}
