package com.syncgym.api.userWorkout.usecases.getActiveWorkoutByUserUsernameUseCase;

import com.syncgym.api.userWorkout.UserWorkout;
import com.syncgym.api.userWorkout.exceptions.UserWorkoutNotFoundException;

public interface GetActiveWorkoutByUserUsernameUseCase {

    UserWorkout execute(String username) throws UserWorkoutNotFoundException;
}
