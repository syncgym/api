package com.syncgym.api.exercise.ports;

import com.syncgym.api.exercise.Exercise;

import java.util.Collection;
import java.util.Optional;

public interface ExerciseRepositoryService {

    Collection<Exercise> getAllExercises();

    Collection<Exercise> getAllExercisesByTargetMuscleGroup(String targetMuscleGroup);

    Collection<Exercise> getAllExercisesByMuscleGroup(String muscleGroup);

    Optional<Exercise> getExerciseByName(String exerciseName);
}
