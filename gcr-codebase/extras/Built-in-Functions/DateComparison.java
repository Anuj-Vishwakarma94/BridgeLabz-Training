//created class named DateComparison
import java.util.*;
public class DateComparison {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        LocalDate date1 = LocalDate.parse(input.nextLine());
        LocalDate date2 = LocalDate.parse(input.nextLine());
		
        //compare the two dates using LocalDate methods
        if(date1.isBefore(date2))
            System.out.println("First date is before the second date");
        else if(date1.isAfter(date2))
            System.out.println("First date is after the second date");
        else if(date1.isEqual(date2))
            System.out.println("Both dates are the same");
    }
}
