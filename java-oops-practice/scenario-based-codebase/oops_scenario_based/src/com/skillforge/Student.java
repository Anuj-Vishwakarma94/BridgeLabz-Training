package com.skillforge;
class Student extends User {

    private int progress;
    private int score;

    public Student(String name) {
        super(name);
    }

    public void updateProgress(int value) {
        progress += value;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getScore() {
        return score;
    }
}
