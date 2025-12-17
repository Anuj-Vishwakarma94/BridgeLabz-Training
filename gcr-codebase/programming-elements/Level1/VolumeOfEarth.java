//Created class named VolumeOfEarth
public class VolumeOfEarth{
  public static void main(String[]args){
		
	//take input of earth's radius and calculate its volue in cubic kilometers and cubic miles
  double radiusofearth=6378;
  double volumeofearthincubickm=(4.0/3.0)*3.14*radiusofearth*radiusofearth*radiusofearth;
  double volumeofearthincubicmiles=volumeofearthincubickm/(1.6*1.6*1.6);
        
	//print the volume in cubic kilometers as well as in cubic miles as well
	System.out.println("The volume of earth in cubic kilometers is "+volumeofearthincubickm+" and and cubic miles is "+volumeofearthincubicmiles);
  }
}