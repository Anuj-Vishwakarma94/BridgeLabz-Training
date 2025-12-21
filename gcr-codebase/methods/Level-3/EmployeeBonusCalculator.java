//Created class Named EmployeeBonusCalculator
public class EmployeeBonusCalculator{
   public static void main(String[]args){

    //generate salary and years of service for 10 employees
    double employeeData[][]=generateEmployeeData();

    //calculate new salary and bonus
    double salaryData[][]=calculateBonusAndNewSalary(employeeData);

    //display summary in tabular format
    calculateAndDisplayTotals(employeeData,salaryData);
   }

   //method to generate salary and years of service
   public static double[][] generateEmployeeData(){
       double data[][]=new double[10][2];

       for(int i=0;i<10;i++){
           data[i][0]=(int)(Math.random()*90000)+10000; 
           data[i][1]=(int)(Math.random()*11);          
       }

       return data;
   }

   //method to calculate bonus and new salary
   public static double[][] calculateBonusAndNewSalary(double data[][]){
       double result[][]=new double[10][2];

       for(int i=0;i<10;i++){
           double salary=data[i][0];
           double years=data[i][1];
           double bonus;

           if(years>5){
               bonus=salary*0.05;
           }
           else{
               bonus=salary*0.02;
           }

           result[i][0]=bonus;
           result[i][1]=salary+bonus;
       }

       return result;
   }

   //method to calculate totals and display result
   public static void calculateAndDisplayTotals(double oldData[][],double newData[][]){
       double totalOldSalary=0;
       double totalNewSalary=0;
       double totalBonus=0;

       System.out.println("Emp\tOldSalary\tYears\tBonus\tNewSalary");

       for(int i=0;i<10;i++){
           System.out.println((i+1) + "\t" +
                              oldData[i][0] + "\t\t" +
                              oldData[i][1] + "\t" +
                              newData[i][0] + "\t" +
                              newData[i][1]);

           totalOldSalary=totalOldSalary+oldData[i][0];
           totalBonus=totalBonus+newData[i][0];
           totalNewSalary=totalNewSalary+newData[i][1];
       }
       System.out.println("Total Old Salary = " + totalOldSalary);
       System.out.println("Total Bonus Paid = " + totalBonus);
       System.out.println("Total New Salary = " + totalNewSalary);
   }
}
