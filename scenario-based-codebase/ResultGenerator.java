//created class named ResultGenerator
import java.util.Scanner;
public class ResultGenerator {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);
        int total = 0;
        int subjects = 5;

        // Input marks using for-loop
        for (int i = 1; i <= subjects; i++) {
            System.out.print("Enter marks for subject " + i + ": ");
            total = total + input.nextInt();
        }
        // Calculate average
        int average = total / subjects;
        char grade;

        // Assign grade using switch
        switch (average / 10) {
            case 10:
            case 9:
                grade = 'A';
                break;
            case 8:
            case 7:
                grade = 'B';
                break;
            case 6:
                grade = 'C';
                break;
            case 5:
            case 4:
                grade = 'D';
                break;
            default:
                grade = 'F';
        }
        // Display result
        System.out.println("\nAverage Marks: " + average);
        System.out.println("Grade: " + grade);
    }
}