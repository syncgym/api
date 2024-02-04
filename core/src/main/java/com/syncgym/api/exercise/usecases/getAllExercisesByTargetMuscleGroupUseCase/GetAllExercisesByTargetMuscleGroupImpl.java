package com.syncgym.api.exercise.usecases.getAllExercisesByTargetMuscleGroupUseCase;

import com.syncgym.api.exercise.Exercise;
import com.syncgym.api.exercise.ports.ExerciseRepositoryService;

import java.util.Collection;

public class GetAllExercisesByTargetMuscleGroupImpl implements GetAllExercisesByTargetMuscleGroupUseCase {

    private final ExerciseRepositoryService exerciseRepositoryService;

    public GetAllExercisesByTargetMuscleGroupImpl(ExerciseRepositoryService exerciseRepositoryService) {
        this.exerciseRepositoryService = exerciseRepositoryService;
    }

    @Override
    public Collection<Exercise> execute(String targetMuscleGroup) {
        return exerciseRepositoryService.getAllExercisesByTargetMuscleGroup(targetMuscleGroup);
    }
}
