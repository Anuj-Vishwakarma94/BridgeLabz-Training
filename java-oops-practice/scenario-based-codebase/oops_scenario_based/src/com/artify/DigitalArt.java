package com.artify;

class DigitalArt extends Artwork {

    public DigitalArt(String title, String artist, double price,
                      String licenseType, boolean previewAvailable) {
        super(title, artist, price, licenseType, previewAvailable);
    }

    @Override
    public void license() {
        System.out.println("Digital License: " + licenseType);
        System.out.println("Usage: Personal digital use only");
    }
}
