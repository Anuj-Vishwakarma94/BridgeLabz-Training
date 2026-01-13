package com.examproctor;
import java.util.HashMap;

public class AnswerBook {

    private HashMap<Integer, String> answers = new HashMap<>();

    public void save(int qid, String ans) {
        answers.put(qid, ans);
    }

    public HashMap<Integer, String> getAll() {
        return answers;
    }
}
