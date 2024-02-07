package com.syncgym.api.workout.usecases.getAllWorkoutsByUserUsernameUseCase;

import com.syncgym.api.workout.Workout;

import java.util.Collection;

public interface GetAllWorkoutsByUserUsernameUseCase {

    Collection<Workout> execute(String username);
}
