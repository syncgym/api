package com.syncgym.api.userWorkout.usecases.getActiveWorkoutByUserUsernameUseCase;

import com.syncgym.api.userWorkout.UserWorkout;
import com.syncgym.api.userWorkout.exceptions.UserWorkoutNotFoundException;
import com.syncgym.api.userWorkout.ports.UserWorkoutRepositoryService;

public class GetActiveWorkoutByUserUsernameUseCaseImpl implements GetActiveWorkoutByUserUsernameUseCase {

    private final UserWorkoutRepositoryService workoutRepositoryService;

    public GetActiveWorkoutByUserUsernameUseCaseImpl(UserWorkoutRepositoryService workoutRepositoryService) {
        this.workoutRepositoryService = workoutRepositoryService;
    }


    @Override
    public UserWorkout execute(String username) throws UserWorkoutNotFoundException {
        return workoutRepositoryService.findActiveWorkoutByUserUsername(username)
                .orElseThrow(UserWorkoutNotFoundException::new);
    }
}
