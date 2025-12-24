import java.time.LocalDate;
import java.util.Scanner;

public class DateArithmetic {
    public static void main(String[] args){
        Scanner input = new Scanner(System.in);
        String inputDate = input.nextLine();
        //create LocalDate from user input
        LocalDate date = LocalDate.parse(inputDate);

        //add days, months, years and then subtract weeks
        LocalDate result = date.plusDays(7)
                               .plusMonths(1)
                               .plusYears(2)
                               .minusWeeks(3);

        System.out.println(result);
    }
}
