package com.syncgym.api.exercise.usecases.getAllExercisesUseCase;

import com.syncgym.api.exercise.Exercise;

import java.util.Collection;

public interface GetAllExercisesUseCase {

    Collection<Exercise> execute();
}
