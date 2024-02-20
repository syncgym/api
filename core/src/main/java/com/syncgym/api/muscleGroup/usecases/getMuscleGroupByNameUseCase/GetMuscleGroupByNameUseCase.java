package com.syncgym.api.muscleGroup.usecases.getMuscleGroupByNameUseCase;

import com.syncgym.api.muscleGroup.MuscleGroup;
import com.syncgym.api.muscleGroup.exceptions.MuscleGroupNotFoundException;

public interface GetMuscleGroupByNameUseCase {

    MuscleGroup execute(String name) throws MuscleGroupNotFoundException;
}
