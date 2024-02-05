package com.syncgym.api.exercise.usecases.getExerciseByNameUseCase;

import com.syncgym.api.exercise.Exercise;
import com.syncgym.api.exercise.exceptions.ExerciseNotFoundException;

public interface GetExerciseByNameUseCase {

    Exercise execute(String exerciseName) throws ExerciseNotFoundException;
}
