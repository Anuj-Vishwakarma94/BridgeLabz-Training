//created class named LongestCommonPrefix
import java.util.*;
public class LongestCommonPrefix{

    //Method to find the longest common prefix among given strings
    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";

        Arrays.sort(strs);
        String s1 = strs[0];
        String s2 = strs[strs.length - 1];
        int count = 0;

        while (count < s1.length() && count < s2.length()) {
            if (s1.charAt(count) == s2.charAt(count)) {
                count++;
            } 
             else {
                break;
            }
        }
        return s1.substring(0, count);
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int N = input.nextInt();
        input.nextLine();

        String[] strs = new String[N];

        for (int i = 0; i < strs.length; i++) {
            System.out.print("Enter string " + (i + 1) + ": ");
            strs[i] = input.nextLine();
        }

        String result = longestCommonPrefix(strs);

        System.out.println("Longest Common Prefix: " + result);
    }
}