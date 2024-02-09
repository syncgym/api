package com.syncgym.api.userWorkout.ports;

import com.syncgym.api.userWorkout.UserWorkout;

import java.util.Collection;
import java.util.Optional;

public interface UserWorkoutRepositoryService {

    Collection<UserWorkout> findAllWorkoutsByUserUsername(String username);

    Optional<UserWorkout> findActiveWorkoutByUserUsername(String username);
}
