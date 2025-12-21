//Created class Named MonthlyCalendar
import java.util.Scanner;
public class MonthlyCalendar{
   public static void main(String[]args){

    Scanner input=new Scanner(System.in);

    //take input for month and year
    int month=input.nextInt();
    int year=input.nextInt();

    String monthName=getMonthName(month);
    int daysInMonth=getDaysInMonth(month,year);
    int firstDay=getFirstDayOfMonth(month,1,year);

    //print calendar header
    System.out.println(monthName + " " + year);
    System.out.println("Sun Mon Tue Wed Thu Fri Sat");

    //print initial spaces
    for(int i=0;i<firstDay;i++){
        System.out.print("    ");
    }

    //print days of the month
    for(int day=1;day<=daysInMonth;day++){
        System.out.printf("%3d ",day);

        if((day+firstDay)%7==0){
            System.out.println();
        }
    }
   }

   //method to get month name
   public static String getMonthName(int month){
       String months[]={"January","February","March","April","May","June",
                        "July","August","September","October","November","December"};
       return months[month-1];
   }

   //method to get number of days in month
   public static int getDaysInMonth(int month,int year){
       int days[]={31,28,31,30,31,30,31,31,30,31,30,31};

       if(month==2 && isLeapYear(year)){
           return 29;
       }

       return days[month-1];
   }

   //method to check leap year
   public static boolean isLeapYear(int year){
       if((year%4==0 && year%100!=0) || year%400==0){
           return true;
       }
       else{
           return false;
       }
   }

   //method to get first day of month using Gregorian algorithm
   public static int getFirstDayOfMonth(int m,int d,int y){
       int y0=y-(14-m)/12;
       int x=y0+y0/4-y0/100+y0/400;
       int m0=m+12*((14-m)/12)-2;
       int d0=(d+x+(31*m0)/12)%7;

       return d0;
   }
}
