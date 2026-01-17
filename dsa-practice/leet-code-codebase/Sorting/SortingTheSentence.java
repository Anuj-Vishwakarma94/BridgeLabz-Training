public class SortingTheSentence {

    public static String sortSentence(String s) {
        String[] words = s.split(" ");
        String[] result = new String[words.length];

        for (String word : words) {
            int index = word.charAt(word.length() - 1) - '1';
            result[index] = word.substring(0, word.length() - 1);
        }

        return String.join(" ", result);
    }

    public static void main(String[] args) {

        String s1 = "is2 sentence4 This1 a3";
        System.out.println(sortSentence(s1));

        String s2 = "Myself2 Me1 I4 and3";
        System.out.println(sortSentence(s2));
    }
}
