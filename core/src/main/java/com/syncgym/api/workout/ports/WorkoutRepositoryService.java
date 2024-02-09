package com.syncgym.api.workout.ports;

import com.syncgym.api.workout.Workout;

import java.util.Collection;

public interface WorkoutRepositoryService {

    Collection<Workout> findAllWorkouts();
}
