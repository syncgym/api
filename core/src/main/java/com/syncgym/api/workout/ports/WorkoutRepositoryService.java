package com.syncgym.api.workout.ports;

import com.syncgym.api.workout.Workout;

import java.util.Collection;
import java.util.Optional;

public interface WorkoutRepositoryService {

    Collection<Workout> findAllWorkouts();

    Collection<Workout> findAllWorkoutsByUserUsername(String username);

    Optional<Workout> findActiveWorkoutByUserUsername(String username);
}
