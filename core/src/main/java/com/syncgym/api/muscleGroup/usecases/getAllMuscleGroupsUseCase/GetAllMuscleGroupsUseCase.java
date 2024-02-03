package com.syncgym.api.muscleGroup.usecases.getAllMuscleGroupsUseCase;

import com.syncgym.api.muscleGroup.MuscleGroup;

import java.util.Collection;

public interface GetAllMuscleGroupsUseCase {

    Collection<MuscleGroup> execute();
}
