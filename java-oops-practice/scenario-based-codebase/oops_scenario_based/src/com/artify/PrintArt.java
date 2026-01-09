package com.artify;

class PrintArt extends Artwork {

    public PrintArt(String title, String artist, double price,
                    String licenseType, boolean previewAvailable) {
        super(title, artist, price, licenseType, previewAvailable);
    }

    @Override
    public void license() {
        System.out.println("Print License: " + licenseType);
        System.out.println("Usage: Limited physical prints allowed");
    }
}
