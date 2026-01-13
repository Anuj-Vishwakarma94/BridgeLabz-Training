package com.examproctor;
import java.util.HashMap;

public class QuestionBank {

    private HashMap<Integer, String> questions = new HashMap<>();
    private HashMap<Integer, String> correctAnswers = new HashMap<>();

    public QuestionBank() {
        questions.put(1, "What is the size of int in Java?\nA) 2 bytes  B) 4 bytes  C) 8 bytes");
        questions.put(2, "Which data structure follows LIFO?\nA) Queue  B) Stack  C) Array");
        questions.put(3, "Which keyword is used for inheritance?\nA) this  B) super  C) extends");

        correctAnswers.put(1, "B");
        correctAnswers.put(2, "B");
        correctAnswers.put(3, "C");
    }

    public String getQuestion(int qid) {
        return questions.get(qid);
    }

    public HashMap<Integer, String> getCorrectAnswers() {
        return correctAnswers;
    }
}
