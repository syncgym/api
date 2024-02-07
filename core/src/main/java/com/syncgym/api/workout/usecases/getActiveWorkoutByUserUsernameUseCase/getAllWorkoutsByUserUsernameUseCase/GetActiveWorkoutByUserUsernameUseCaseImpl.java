package com.syncgym.api.workout.usecases.getActiveWorkoutByUserUsernameUseCase.getAllWorkoutsByUserUsernameUseCase;

import com.syncgym.api.workout.Workout;
import com.syncgym.api.workout.exceptions.WorkoutNotFoundException;
import com.syncgym.api.workout.ports.WorkoutRepositoryService;

public class GetActiveWorkoutByUserUsernameUseCaseImpl implements GetActiveWorkoutByUserUsernameUseCase {

    private final WorkoutRepositoryService workoutRepositoryService;

    public GetActiveWorkoutByUserUsernameUseCaseImpl(WorkoutRepositoryService workoutRepositoryService) {
        this.workoutRepositoryService = workoutRepositoryService;
    }


    @Override
    public Workout execute(String username) throws WorkoutNotFoundException {
        return workoutRepositoryService.findActiveWorkoutByUserUsername(username)
                .orElseThrow(WorkoutNotFoundException::new);
    }
}
