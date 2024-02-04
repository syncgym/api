package com.syncgym.api.exercise.usecases.getAllExercisesByMuscleGroupUseCase;

import com.syncgym.api.exercise.Exercise;

import java.util.Collection;

public interface GetAllExercisesByMuscleGroupUseCase {

    Collection<Exercise> execute(String muscleGroup);
}
