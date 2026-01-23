package com.musicapp;

public class SongNode {

    String title;        
    int trackId;       
    String artist;     

    SongNode left;
    SongNode right;

    SongNode(String title, int trackId, String artist) {
        this.title = title;
        this.trackId = trackId;
        this.artist = artist;
        left = null;
        right = null;
    }
}

