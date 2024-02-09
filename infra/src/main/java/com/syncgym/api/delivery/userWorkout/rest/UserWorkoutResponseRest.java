package com.syncgym.api.delivery.userWorkout.rest;

import com.syncgym.api.delivery.workout.rest.WorkoutResponseRest;

import java.io.Serial;
import java.io.Serializable;

public record UserWorkoutResponseRest(
        Byte completedSplits,
        Boolean isActive,
        WorkoutResponseRest workout
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
