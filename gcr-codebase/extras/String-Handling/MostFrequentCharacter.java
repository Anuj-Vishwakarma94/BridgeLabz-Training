//created class named MostFrequentCharacter
import java.util.Scanner;
public class MostFrequentCharacter {
    public static void main(String[] args) {
        Scanner input=new Scanner(System.in);

        // Take input string
        String text=input.nextLine();
        int frequency[]=new int[256];
        for(int i=0;i<text.length();i++){
            char ch=text.charAt(i);
            frequency[ch]++;
        }

        char mostFrequent=text.charAt(0);
        int maxCount=frequency[mostFrequent];

        // Find character with maximum frequency
        for(int i =1;i<text.length();i++){
            char ch=text.charAt(i);
            if(frequency[ch]>maxCount){
                maxCount=frequency[ch];
                mostFrequent=ch;
            }
        }
        // Display result
        System.out.println("Most Frequent Character: "+mostFrequent);
    }
}
