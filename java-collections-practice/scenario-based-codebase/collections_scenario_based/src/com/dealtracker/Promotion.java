package com.dealtracker;
public class Promotion<T> {

    private T type;

    public Promotion(T type) {
        this.type = type;
    }

    public T getType() {
        return type;
    }
}