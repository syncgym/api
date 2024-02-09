package com.syncgym.api.userWorkout;

import com.syncgym.api.commonUser.CommonUser;
import com.syncgym.api.workout.Workout;

import java.io.Serial;
import java.io.Serializable;

public record UserWorkout(
        CommonUser commonUser,
        Workout workout,
        Byte completedSplits,
        Boolean isActive
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
