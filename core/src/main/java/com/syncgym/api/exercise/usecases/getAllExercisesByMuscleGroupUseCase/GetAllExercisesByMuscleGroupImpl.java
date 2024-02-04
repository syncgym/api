package com.syncgym.api.exercise.usecases.getAllExercisesByMuscleGroupUseCase;

import com.syncgym.api.exercise.Exercise;
import com.syncgym.api.exercise.ports.ExerciseRepositoryService;

import java.util.Collection;

public class GetAllExercisesByMuscleGroupImpl implements GetAllExercisesByMuscleGroupUseCase {

    private final ExerciseRepositoryService exerciseRepositoryService;

    public GetAllExercisesByMuscleGroupImpl(ExerciseRepositoryService exerciseRepositoryService) {
        this.exerciseRepositoryService = exerciseRepositoryService;
    }

    @Override
    public Collection<Exercise> execute(String muscleGroup) {
        return exerciseRepositoryService.getAllExercisesByMuscleGroup(muscleGroup);
    }
}
