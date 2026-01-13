package com.examproctor;
import java.util.*;

public class ExamProctor {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        QuestionBank bank = new QuestionBank();
        QuestionNavigator navigator = new QuestionNavigator();
        AnswerBook answerBook = new AnswerBook();
        ScoreEvaluator evaluator = new ScoreEvaluator();

        while (true) {

            System.out.println("\n1 Visit Question");
            System.out.println("2 Answer Question");
            System.out.println("3 Go Back");
            System.out.println("4 Submit Exam");
            int choice = sc.nextInt();

            if (choice == 1) {
                System.out.print("Enter Question ID (1-3): ");
                int qid = sc.nextInt();
                navigator.visit(qid);
                System.out.println(bank.getQuestion(qid));
            }

            else if (choice == 2) {
                Integer qid = navigator.current();
                if (qid == null) {
                    System.out.println("No active question");
                } else {
                    System.out.print("Enter Answer (A/B/C): ");
                    String ans = sc.next();
                    answerBook.save(qid, ans);
                    System.out.println("Answer saved");
                }
            }

            else if (choice == 3) {
                Integer prev = navigator.back();
                if (prev == null) {
                    System.out.println("No previous question");
                } else {
                    System.out.println(bank.getQuestion(prev));
                }
            }

            else if (choice == 4) {
                int score = evaluator.evaluate(answerBook.getAll(), bank.getCorrectAnswers());
                System.out.println("Final Score: " + score + "/3");
                break;
            }
        }
    }
}
