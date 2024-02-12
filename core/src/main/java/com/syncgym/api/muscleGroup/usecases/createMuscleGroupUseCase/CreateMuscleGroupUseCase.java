package com.syncgym.api.muscleGroup.usecases.createMuscleGroupUseCase;

import com.syncgym.api.muscleGroup.MuscleGroup;
import com.syncgym.api.muscleGroup.exceptions.MuscleGroupAlreadyExistsException;

public interface CreateMuscleGroupUseCase {

    MuscleGroup execute(String name) throws MuscleGroupAlreadyExistsException;
}
