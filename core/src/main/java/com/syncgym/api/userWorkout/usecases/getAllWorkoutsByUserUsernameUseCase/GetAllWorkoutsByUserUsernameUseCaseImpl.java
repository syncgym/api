package com.syncgym.api.userWorkout.usecases.getAllWorkoutsByUserUsernameUseCase;

import com.syncgym.api.userWorkout.UserWorkout;
import com.syncgym.api.userWorkout.ports.UserWorkoutRepositoryService;

import java.util.Collection;

public class GetAllWorkoutsByUserUsernameUseCaseImpl implements GetAllWorkoutsByUserUsernameUseCase {

    private final UserWorkoutRepositoryService workoutRepositoryService;

    public GetAllWorkoutsByUserUsernameUseCaseImpl(UserWorkoutRepositoryService workoutRepositoryService) {
        this.workoutRepositoryService = workoutRepositoryService;
    }

    @Override
    public Collection<UserWorkout> execute(String username) {
        return workoutRepositoryService.findAllWorkoutsByUserUsername(username);
    }
}
