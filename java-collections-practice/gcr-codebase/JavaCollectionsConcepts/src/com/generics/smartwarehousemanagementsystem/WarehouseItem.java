package com.generics.smartwarehousemanagementsystem;

public abstract class WarehouseItem {
    private String name;
    private double price;

    public WarehouseItem(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public abstract String getCategory();

    @Override
    public String toString() {
        return getCategory() + " [Name=" + name + ", Price=" + price + "]";
    }
}
