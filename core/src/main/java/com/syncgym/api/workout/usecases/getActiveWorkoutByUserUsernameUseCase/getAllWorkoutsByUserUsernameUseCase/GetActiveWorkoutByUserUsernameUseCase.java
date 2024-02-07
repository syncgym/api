package com.syncgym.api.workout.usecases.getActiveWorkoutByUserUsernameUseCase.getAllWorkoutsByUserUsernameUseCase;

import com.syncgym.api.workout.Workout;
import com.syncgym.api.workout.exceptions.WorkoutNotFoundException;

public interface GetActiveWorkoutByUserUsernameUseCase {

    Workout execute(String username) throws WorkoutNotFoundException;
}
