package com.examproctor;
import java.util.HashMap;

public class ScoreEvaluator {

    public int evaluate(HashMap<Integer, String> student, HashMap<Integer, String> correct) {
        int score = 0;

        for (int qid : correct.keySet()) {
            if (student.containsKey(qid) && student.get(qid).equalsIgnoreCase(correct.get(qid))) {
                score++;
            }
        }
        return score;
    }
}
