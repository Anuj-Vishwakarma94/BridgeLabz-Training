package com.linearandbinarysearch.linearsearch;
public class SentenceSearch {

    public static String findSentence(String[] sentences, String word) {
        for (String sentence : sentences) {
            if (sentence.toLowerCase().contains(word.toLowerCase())) {
                return sentence;
            }
        }
        return "Not Found";
    }

    public static void main(String[] args) {

        String[] sentences = {
            "Java is a powerful language",
            "Linear search is simple",
            "Core java programming",
            "BrideLabz Training"
        };

        String word = "BrideLabz";

        String result = findSentence(sentences, word);

        System.out.println(result);
    }
}
