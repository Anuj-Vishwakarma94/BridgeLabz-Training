package com.lambdaexpression.notificationfiltering;

public class Alert {
    String message;
    String type; 

    Alert(String message, String type) {
        this.message = message;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return message + " (" + type + ")";
    }
}