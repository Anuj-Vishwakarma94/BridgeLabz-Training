package com.onlineticketbookingbytime;

public class EventNode {

    int eventTime; 
    String eventName;

    int height;

    EventNode left;
    EventNode right;

    EventNode(int eventTime, String eventName) {
        this.eventTime = eventTime;
        this.eventName = eventName;
        this.height = 1;
        this.left = null;
        this.right = null;
    }
}

