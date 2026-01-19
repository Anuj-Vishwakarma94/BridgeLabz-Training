package com.artexpo;

public class ArtistRegistry {

    private Artist[] artists;
    private int size;

    public ArtistRegistry(int capacity) {
        artists = new Artist[capacity];
        size = 0;
    }

    public void addArtist(Artist artist) {
        int i = size - 1;
        while (i >= 0 && artists[i].getTimeInMinutes() > artist.getTimeInMinutes()) {
            artists[i + 1] = artists[i];
            i--;
        }
        artists[i + 1] = artist;
        size++;
    }

    public void displayArtists() {
        for (int i = 0; i < size; i++) {
            System.out.println((i + 1) + ". " + artists[i]);
        }
    }
}
