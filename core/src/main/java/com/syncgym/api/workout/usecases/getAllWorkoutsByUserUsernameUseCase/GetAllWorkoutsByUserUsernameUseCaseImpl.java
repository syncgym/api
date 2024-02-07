package com.syncgym.api.workout.usecases.getAllWorkoutsByUserUsernameUseCase;

import com.syncgym.api.workout.Workout;
import com.syncgym.api.workout.ports.WorkoutRepositoryService;

import java.util.Collection;

public class GetAllWorkoutsByUserUsernameUseCaseImpl implements GetAllWorkoutsByUserUsernameUseCase {

    private final WorkoutRepositoryService workoutRepositoryService;

    public GetAllWorkoutsByUserUsernameUseCaseImpl(WorkoutRepositoryService workoutRepositoryService) {
        this.workoutRepositoryService = workoutRepositoryService;
    }

    @Override
    public Collection<Workout> execute(String username) {
        return workoutRepositoryService.findAllWorkoutsByUserUsername(username);
    }
}
