package com.syncgym.api.exercise.usecases.getAllExercisesUseCase;

import com.syncgym.api.exercise.Exercise;
import com.syncgym.api.exercise.ports.ExerciseRepositoryService;

import java.util.Collection;

public class GetAllExercisesUseCaseImpl implements GetAllExercisesUseCase {

    private final ExerciseRepositoryService exerciseRepositoryService;

    public GetAllExercisesUseCaseImpl(ExerciseRepositoryService exerciseRepositoryService) {
        this.exerciseRepositoryService = exerciseRepositoryService;
    }

    @Override
    public Collection<Exercise> execute() {
        return exerciseRepositoryService.getAllExercises();
    }
}
