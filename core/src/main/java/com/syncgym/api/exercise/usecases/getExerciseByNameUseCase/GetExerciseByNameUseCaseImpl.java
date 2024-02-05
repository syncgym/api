package com.syncgym.api.exercise.usecases.getExerciseByNameUseCase;

import com.syncgym.api.exercise.Exercise;
import com.syncgym.api.exercise.exceptions.ExerciseNotFoundException;
import com.syncgym.api.exercise.ports.ExerciseRepositoryService;

public class GetExerciseByNameUseCaseImpl implements GetExerciseByNameUseCase {

    private final ExerciseRepositoryService exerciseRepositoryService;

    public GetExerciseByNameUseCaseImpl(ExerciseRepositoryService exerciseRepositoryService) {
        this.exerciseRepositoryService = exerciseRepositoryService;
    }

    @Override
    public Exercise execute(String exerciseName) throws ExerciseNotFoundException {
        return exerciseRepositoryService.getExerciseByName(exerciseName)
                .orElseThrow(ExerciseNotFoundException::new);
    }
}
