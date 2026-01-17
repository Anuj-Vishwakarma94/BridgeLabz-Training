package com.robowarehouse;

class Package {
    String id;
    double weight;

    public Package(String id, double weight) {
        this.id = id;
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Weight: " + weight + " kg";
    }
}
