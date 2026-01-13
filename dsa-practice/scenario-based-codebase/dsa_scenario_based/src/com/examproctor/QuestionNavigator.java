package com.examproctor;
import java.util.Stack;

public class QuestionNavigator {

    private Stack<Integer> stack = new Stack<>();

    public void visit(int qid) {
        stack.push(qid);
    }

    public Integer back() {
        if (stack.size() <= 1) return null;
        stack.pop();
        return stack.peek();
    }

    public Integer current() {
        if (stack.isEmpty()) return null;
        return stack.peek();
    }
}
