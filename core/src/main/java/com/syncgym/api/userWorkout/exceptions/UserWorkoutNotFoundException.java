package com.syncgym.api.userWorkout.exceptions;

public class UserWorkoutNotFoundException extends Exception {

    public UserWorkoutNotFoundException() {
        super("workout of user not found");
    }
}
