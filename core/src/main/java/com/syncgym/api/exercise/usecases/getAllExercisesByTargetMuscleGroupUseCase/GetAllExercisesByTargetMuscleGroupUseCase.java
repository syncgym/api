package com.syncgym.api.exercise.usecases.getAllExercisesByTargetMuscleGroupUseCase;

import com.syncgym.api.exercise.Exercise;

import java.util.Collection;

public interface GetAllExercisesByTargetMuscleGroupUseCase {

    Collection<Exercise> execute(String targetMuscleGroup);
}
