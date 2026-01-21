import java.util.*;

public class LetterCombinationsOfAPhoneNumber {

    static String mapping[] = {
            "", "", "abc", "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz"
    };

    static void solve(int index, String digits, String current, List<String> result) {
        if (index == digits.length()) {
            result.add(current);
            return;
        }

        String letters = mapping[digits.charAt(index) - '0'];

        for (int i = 0; i < letters.length(); i++) {
            solve(index + 1, digits, current + letters.charAt(i), result);
        }
    }

    public static List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) return result;
        solve(0, digits, "", result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String digits = sc.nextLine();

        List<String> ans = letterCombinations(digits);

        for (String s : ans) {
            System.out.print(s + " ");
        }
    }
}
