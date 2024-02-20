package com.syncgym.api.muscleGroup.usecases.deleteMuscleGroupUseCase;

import com.syncgym.api.muscleGroup.exceptions.MuscleGroupNotFoundException;

public interface DeleteMuscleGroupUseCase {

    void execute(String name) throws MuscleGroupNotFoundException;
}
