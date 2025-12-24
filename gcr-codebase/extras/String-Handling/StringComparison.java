//created class named StringComparison
import java.util.Scanner;
public class StringComparison {
    public static void main(String[] args) {

        Scanner input=new Scanner(System.in);
        String s1=input.next();
        String s2=input.next();

        int result = compareStrings(s1, s2);
        //display the string in lexicographical order
        if (result < 0) {
            System.out.println("\"" + s1 + "\" comes before \"" + s2 + "\" in lexicographical order");
        } 
        else if (result > 0) {
            System.out.println("\"" + s1 + "\" comes after \"" + s2 + "\" in lexicographical order");
        } 
        else {
            System.out.println("Both strings are equal");
        }
    }
    //method to compare two strings lexicographically
    public static int compareStrings(String s1, String s2) {
        int minLength = Math.min(s1.length(), s2.length());
        for (int i = 0; i < minLength; i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                return s1.charAt(i) - s2.charAt(i);
            }
        }
        return s1.length() - s2.length();
    }
}
