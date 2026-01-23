package com.gamingapp;

public class PlayerNode {

    int score;         
    String playerName;

    int height;

    PlayerNode left;
    PlayerNode right;

    PlayerNode(int score, String playerName) {
        this.score = score;
        this.playerName = playerName;
        height = 1;
        left = null;
        right = null;
    }
}


