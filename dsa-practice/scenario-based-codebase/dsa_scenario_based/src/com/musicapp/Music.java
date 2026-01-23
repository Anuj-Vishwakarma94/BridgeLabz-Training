package com.musicapp;

public class Music {

    SongNode root;
    
    SongNode insert(SongNode root, String title, int trackId, String artist) {
        if (root == null) {
            return new SongNode(title, trackId, artist);
        }

        if (title.compareToIgnoreCase(root.title) < 0) {
            root.left = insert(root.left, title, trackId, artist);
        } else if (title.compareToIgnoreCase(root.title) > 0) {
            root.right = insert(root.right, title, trackId, artist);
        }

        return root;
    }

    SongNode searchByTrackId(SongNode root, int trackId) {
        if (root == null) {
            return null;
        }

        if (root.trackId == trackId) {
            return root;
        }

        SongNode found = searchByTrackId(root.left, trackId);
        if (found != null) {
            return found;
        }

        return searchByTrackId(root.right, trackId);
    }

    void inorder(SongNode root) {
        if (root != null) {
            inorder(root.left);
            System.out.println("Title: " + root.title + " | Track ID: " + root.trackId + " | Artist: " + root.artist);
            inorder(root.right);
        }
    }
}
