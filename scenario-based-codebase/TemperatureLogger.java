/*11. Temperature Logger 🌡️
Record temperatures over 7 days.
● Use array and for-loop.
● Find average and max temperature.
● Use if for comparisons. Maintain readable naming and modular code blocks.*/

//created class named TemperatureLogger
import java.util.Scanner;
    public class  TemperatureLogger  {
    public static void main(String[] args){
	Scanner input=new Scanner(System.in);
	System.out.println("Welcome to TemperatureLogger!!");
	System.out.print("Enter the temperature of the whole week (In Celsius) :");
	int[] temp = new int[7];
	int max=0;
	int sum=0;
	for(int i = 0; i < temp.length ; i++)
	{
		System.out.println("Day " + (i+1) + " :");
		temp[i]= input.nextInt();
	}
	for(int i = 0; i < temp.length ; i++)
	{
		if(temp[i] > max)
		{
			max=temp[i];
		}
	}
	
	//display Max temperature and average temperature
	for(int i = 0; i < temp.length ; i++){
		sum = sum + temp[i];
	}
	int totalnum = temp.length;
	int avg = sum/totalnum;
	System.out.println("The Max Temp. is :" + max);
	System.out.println("The Average Temperature the whole week was :" + avg);
	}
}