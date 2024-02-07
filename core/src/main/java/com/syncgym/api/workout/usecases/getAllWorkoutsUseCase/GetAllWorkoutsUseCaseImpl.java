package com.syncgym.api.workout.usecases.getAllWorkoutsUseCase;

import com.syncgym.api.workout.Workout;
import com.syncgym.api.workout.ports.WorkoutRepositoryService;

import java.util.Collection;

public class GetAllWorkoutsUseCaseImpl implements GetAllWorkoutsUseCase {

    private final WorkoutRepositoryService workoutRepositoryService;

    public GetAllWorkoutsUseCaseImpl(WorkoutRepositoryService workoutRepositoryService) {
        this.workoutRepositoryService = workoutRepositoryService;
    }

    @Override
    public Collection<Workout> execute() {
        return workoutRepositoryService.findAllWorkouts();
    }
}
