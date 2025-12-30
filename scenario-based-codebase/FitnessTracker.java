/*13. Sandeep’s Fitness Challenge Tracker 🏋️
♂Each day Sandeep completes a number of push-ups.
● Store counts for a week.
● Use for-each to calculate total and average.
● Use continue to skip rest days.*/

//created class named FitnessTracker
import java.util.Scanner;
public class  FitnessTracker{
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        System.out.println("Welcome to Push-ups Tracker");
        System.out.println("Enter the number of Push-ups per day");
        System.out.println("Type 0 if you want a rest day");
        int activeDays = 0;
        int totalPushups = 0;
        int[] days = new int[7];

        for (int i = 0; i < days.length; i++) {
            System.out.print("Day " + (i + 1) + " : ");
            days[i] = input.nextInt();
        }
        for (int num : days) {
            if (num == 0) continue;
            totalPushups += num;
            activeDays++;
        }
        //display active days average push ups and total push ups
        if (activeDays > 0) {
            int avg = totalPushups / activeDays;
            System.out.println(  "Active Days : " + activeDays +"\nAverage Push-ups : " + avg +"\nTotal Push-ups : " + totalPushups);	
        } 
		else {
            System.out.println("No active days recorded.");
        }
    }
}
