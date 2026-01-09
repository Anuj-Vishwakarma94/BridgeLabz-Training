package com.artify;

abstract class Artwork implements IPurchasable {

    protected String title;
    protected String artist;
    protected double price;
    protected String licenseType;   
    protected boolean previewAvailable;

    protected Artwork(String title, String artist, double price, String licenseType, boolean previewAvailable) {
        this.title = title;
        this.artist = artist;
        this.price = price;
        this.licenseType = licenseType;
        this.previewAvailable = previewAvailable;
    }

    public void purchase(User user) {
        if (user.getWalletBalance() >= price) {
            user.deductBalance(price);   
            System.out.println("Purchased: " + title);
            license();
        } else {
            System.out.println("Not enough balance");
        }
    }
    public abstract void license();
}
