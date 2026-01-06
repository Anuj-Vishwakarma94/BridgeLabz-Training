package com.fittrack;

public abstract class Workout implements ITrackable {

    protected String type;
    protected int duration;
    protected double caloriesBurned;

    private String workoutLog = "Workout started...";

    public Workout(String type, int duration) {
        this.type = type;
        this.duration = duration;
    }

    public abstract void calculateCalories();

    public double getCaloriesBurned() {
        return caloriesBurned;
    }

    @Override
    public void startWorkout() {
        System.out.println(type + " workout started.");
    }

    @Override
    public void stopWorkout() {
        System.out.println(type + " workout stopped.");
    }
}

