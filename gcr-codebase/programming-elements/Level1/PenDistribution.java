//Created class Named PenDistribution
public class PenDistribution{
    public static void main(String[]args){
    
	//take total number of pens and number of students as the input from user and then calculate pen per student and remaining pen
	int totalnumberofpens=14;
    int numberofstudents=3;
    int penperstudent=14/3;
    int remainingpen=14%3;
    
	//print number of pen per student and the remaining pen as well
	System.out.println("The Pen Per Student is "+penperstudent+" and the remaining pen not distributed is "+remainingpen);
    }
}