import java.util.*;

public class WordsContaining {

    public static List<Integer> findWordsContaining(String[] words, char x) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].indexOf(x) != -1) {
                result.add(i);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        String[] words = new String[n];
        for (int i = 0; i < n; i++) {
            words[i] = input.next();
        }
        char x = input.next().charAt(0);
        System.out.println(findWordsContaining(words, x));
    }
}
