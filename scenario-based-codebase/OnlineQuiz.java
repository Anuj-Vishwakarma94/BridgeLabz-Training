/*17. Online Quiz Application 🧠
Ask 5 questions (MCQs) from a user.
● Use arrays and for-loop.
● Record score.
● Switch for answer checking. Apply clear indentation and structured layout.*/

//created class named OnlineQuiz
import java.util.*;
public class OnlineQuiz{
    public static void main(String[]args){
        Scanner input=new Scanner(System.in);
	    String []Question={"Which keyword is used to create a class in Java?","Which data type is used to store decimal numbers in Java?","Which method is the entry point of a Java program?","Which symbol is used for single-line comments in Java?","Which of the following is NOT a Java primitive data type?"};
		String []Options={"a)struct b)class c)define d)object","a)int b)boolean c)double d)char","a)start() b)run() c)main() d)execute()","a)* b)// c)# d)<!-- -->","a)int b)float c)String d)char"};
		char []Answers={'b','c','c','b','c'};
		int score = 0;
        System.out.println("===== Online Quiz Application =====\n");
        for(int i = 0; i < 5; i++) {
            System.out.println(Question[i]);
            System.out.println(Options[i]);
            System.out.print("Enter your answer (a/b/c/d): ");
            char userAns = input.next().charAt(0);
            switch(userAns) {
                case 'a':
                case 'b':
                case 'c':
                case 'd':
                    if(userAns == Answers[i]) {
                        System.out.println("Correct!\n");
                        score++;
                    } 
                    else {
                        System.out.println("Wrong! Correct answer is: " + Answers[i] + "\n");
                    }
                    break;

                default:
                    System.out.println("Invalid option! Question skipped.\n");
            }
        }
        System.out.println("Your Score: " + score + " / 5");
	}
}