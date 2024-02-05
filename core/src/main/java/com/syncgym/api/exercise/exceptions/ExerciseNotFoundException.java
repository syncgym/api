package com.syncgym.api.exercise.exceptions;

public class ExerciseNotFoundException extends Exception {

    public ExerciseNotFoundException() {
        super("Exercise not found");
    }
}
