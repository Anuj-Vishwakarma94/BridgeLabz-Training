package com.examresultuploader;
public class ExamRecord<T> {

    private T examType;
    private String subject;
    private int marks;

    public ExamRecord(T examType, String subject, int marks) {
        this.examType = examType;
        this.subject = subject;
        this.marks = marks;
    }

    public T getExamType() {
        return examType;
    }

    public String getSubject() {
        return subject;
    }

    public int getMarks() {
        return marks;
    }
}