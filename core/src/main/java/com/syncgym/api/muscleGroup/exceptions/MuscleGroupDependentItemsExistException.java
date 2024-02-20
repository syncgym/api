package com.syncgym.api.muscleGroup.exceptions;

public class MuscleGroupDependentItemsExistException extends Exception {

    public MuscleGroupDependentItemsExistException() {
        super("Dependent items exist. Cannot delete.");
    }
}
