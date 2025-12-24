//created class named RemoveCharacter
import java.util.Scanner;
public class RemoveCharacter{
    public static void main(String[] args) {
	    // take text and character to remove as input
        Scanner input=new Scanner(System.in);
        String text=input.nextLine();
        char removeChar=input.next().charAt(0);

        String result = "";
        for (int i = 0; i < text.length(); i++) {
            if (text.charAt(i) != removeChar) {
                result = result + text.charAt(i);
            }
        }

        // Display result
        System.out.println("Modified String: " + result);
    }
}
