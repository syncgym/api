package com.syncgym.api.workout.exceptions;

public class WorkoutNotFoundException extends Exception {

    public WorkoutNotFoundException() {
        super("Workout not found");
    }
}
