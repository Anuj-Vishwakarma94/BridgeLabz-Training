package com.fittrack;

public class StrengthWorkout extends Workout {

    public StrengthWorkout(int duration) {
        super("Strength", duration);
    }

    @Override
    public void calculateCalories() {
        caloriesBurned = duration * 6.2;
    }
}
