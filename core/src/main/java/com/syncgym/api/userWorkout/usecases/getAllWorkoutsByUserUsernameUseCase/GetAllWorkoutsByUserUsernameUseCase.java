package com.syncgym.api.userWorkout.usecases.getAllWorkoutsByUserUsernameUseCase;

import com.syncgym.api.userWorkout.UserWorkout;

import java.util.Collection;

public interface GetAllWorkoutsByUserUsernameUseCase {

    Collection<UserWorkout> execute(String username);
}
