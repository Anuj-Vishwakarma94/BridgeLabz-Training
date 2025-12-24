// Created class named ReplaceWord
import java.util.Scanner;

public class ReplaceWord {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        // Take input sentence
        String sentence = input.nextLine();
        String oldWord = input.next();
        String newWord = input.next();
        String result = replace(sentence, oldWord, newWord);
        System.out.println("Modified Sentence: " + result);
    }

    // Method to replace a word in a sentence
    public static String replace(String sentence, String oldWord, String newWord) {

        String result = "";
        int i = 0;

        while (i < sentence.length()) {

            if (i + oldWord.length() <= sentence.length()
                    && sentence.substring(i, i + oldWord.length()).equals(oldWord)) {

                result = result + newWord;
                i = i + oldWord.length();
            }
            else {
                result = result + sentence.charAt(i);
                i++;
            }
        }

        return result;
    }
}
