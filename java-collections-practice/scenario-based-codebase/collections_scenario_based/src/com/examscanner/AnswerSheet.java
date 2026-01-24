package com.examscanner;
public class AnswerSheet<T> {

    private String studentName;
    private T answers;

    public AnswerSheet(String studentName, T answers) {
        this.studentName = studentName;
        this.answers = answers;
    }

    public String getStudentName() {
        return studentName;
    }

    public T getAnswers() {
        return answers;
    }
}