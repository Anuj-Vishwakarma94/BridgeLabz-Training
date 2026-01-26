package com.bagnballorganizer;
import java.util.ArrayList;

public class Bag {

    private String id;
    private String color;
    private int capacity;
    private ArrayList<Ball> balls;

    public Bag(String id, String color, int capacity) {
        this.id = id;
        this.color = color;
        this.capacity = capacity;
        this.balls = new ArrayList<>();
    }

    public String getId() {
        return id;
    }

    public int getBallCount() {
        return balls.size();
    }

    // Add ball (check capacity)
    public void addBall(Ball ball) {
        if (balls.size() >= capacity) {
            System.out.println("Bag is full. Cannot add more balls.");
            return;
        }
        balls.add(ball);
        System.out.println("Ball added to bag " + id);
    }

    // Remove ball by ID
    public void removeBall(String ballId) {
        for (Ball b : balls) {
            if (b.getId().equals(ballId)) {
                balls.remove(b);
                System.out.println("Ball removed from bag " + id);
                return;
            }
        }
        System.out.println("Ball not found.");
    }

    // Display balls in bag
    public void displayBalls() {
        if (balls.isEmpty()) {
            System.out.println("No balls in this bag.");
            return;
        }

        for (Ball b : balls) {
            System.out.println(
                "Ball ID: " + b.getId() +
                ", Color: " + b.getColor() +
                ", Size: " + b.getSize()
            );
        }
    }
}
