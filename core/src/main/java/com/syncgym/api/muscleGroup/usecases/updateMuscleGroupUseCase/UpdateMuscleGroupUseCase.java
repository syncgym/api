package com.syncgym.api.muscleGroup.usecases.updateMuscleGroupUseCase;

import com.syncgym.api.muscleGroup.MuscleGroup;
import com.syncgym.api.muscleGroup.exceptions.MuscleGroupNotFoundException;

public interface UpdateMuscleGroupUseCase {

    MuscleGroup execute(String newName, String name) throws MuscleGroupNotFoundException;
}
