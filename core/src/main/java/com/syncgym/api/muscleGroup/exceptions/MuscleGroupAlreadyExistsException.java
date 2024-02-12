package com.syncgym.api.muscleGroup.exceptions;

public class MuscleGroupAlreadyExistsException extends Exception {

    public MuscleGroupAlreadyExistsException() {
        super("Muscle group already exists");
    }
}
