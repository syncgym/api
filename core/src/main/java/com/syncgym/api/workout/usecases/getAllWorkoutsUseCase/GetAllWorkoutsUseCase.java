package com.syncgym.api.workout.usecases.getAllWorkoutsUseCase;

import com.syncgym.api.workout.Workout;

import java.util.Collection;

public interface GetAllWorkoutsUseCase {

    Collection<Workout> execute();
}
