package com.syncgym.api.exercise.ports;

import com.syncgym.api.exercise.Exercise;

import java.util.Collection;

public interface ExerciseRepositoryService {

    Collection<Exercise> getAllExercisesByTargetMuscleGroup(String targetMuscleGroup);

    Collection<Exercise> getAllExercisesByMuscleGroup(String muscleGroup);
}
