package com.edumentor;
import java.util.*;

public class Quiz {

    private List<String> questions;          
    private List<String> correctAnswers;    
    private int score;
    private int total;

   
    public Quiz(String difficulty) {
        questions = new ArrayList<>();
        correctAnswers = new ArrayList<>();

        if(difficulty.equalsIgnoreCase("easy")) {
            questions.add("Java is platform independent? (yes/no)");
            correctAnswers.add("yes");

            questions.add("OOP means Object Oriented Programming? (yes/no)");
            correctAnswers.add("yes");
        }
        else if(difficulty.equalsIgnoreCase("hard")) {
            questions.add("Polymorphism means many forms? (yes/no)");
            correctAnswers.add("yes");

            questions.add("Abstraction hides details? (yes/no)");
            correctAnswers.add("yes");

            questions.add("Java supports multiple inheritance using classes? (yes/no)");
            correctAnswers.add("no");
        }

        total = questions.size();
    }


    public List<String> getQuestions() {
        return Collections.unmodifiableList(questions);
    }

   

    public void attemptQuiz(List<String> userAnswers) {
        score = 0;
        for(int i = 0; i < total; i++) {
            if(userAnswers.get(i).equalsIgnoreCase(correctAnswers.get(i))) {
                score++;
            }
        }
    }

    public double getPercentage() {
        return (score * 100.0) / total;   
    }

    public int getScore() {
        return score;
    }
}
