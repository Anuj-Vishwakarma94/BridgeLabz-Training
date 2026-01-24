package com.chatlogparser;
import java.util.*;

public class IdleMessageFilter implements MessageFilter<String> {

    private Set<String> blockedWords = new HashSet<>(Arrays.asList("lol", "brb", "haha"));

    @Override
    public boolean allow(String message) {
        String lower = message.toLowerCase();
        for (String word : blockedWords) {
            if (lower.contains(word)) {
                return false;
            }
        }
        return true;
    }
}