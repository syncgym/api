package com.syncgym.api.muscleGroup.exceptions;

public class MuscleGroupNotFoundException extends Exception {

    public MuscleGroupNotFoundException() {
        super("Muscle group not found");
    }
}
