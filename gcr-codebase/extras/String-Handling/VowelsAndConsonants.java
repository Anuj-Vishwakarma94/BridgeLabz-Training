//created class named VowelsAndConsonants
import java.util.Scanner;
public class VowelsAndConsonants{
    public static void main(String[]args){
		
		//take text as input
        Scanner input=new Scanner(System.in);
        String text=input.next();
		int countVowels=0;
		int countConsonants=0;
        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);
            if(ch=='a' || ch=='e' || ch=='i' || ch=='o' || ch=='u' || ch=='A' || ch=='E' || ch=='I' || ch=='O' || ch=='U'){
                countVowels++;
            }
			else{
                countConsonants++;
            }	
		}
		
		//display the number of vowels and Consonants
		System.out.println("Number of Vowels : "+countVowels);
		System.out.println("Number of Consonants : "+countConsonants);
   }
}