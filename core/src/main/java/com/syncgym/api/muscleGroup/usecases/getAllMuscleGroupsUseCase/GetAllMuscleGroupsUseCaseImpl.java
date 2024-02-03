package com.syncgym.api.muscleGroup.usecases.getAllMuscleGroupsUseCase;

import com.syncgym.api.muscleGroup.MuscleGroup;
import com.syncgym.api.muscleGroup.ports.MuscleGroupRepositoryService;

import java.util.Collection;

public class GetAllMuscleGroupsUseCaseImpl implements GetAllMuscleGroupsUseCase {

    private final MuscleGroupRepositoryService muscleGroupRepositoryService;

    public GetAllMuscleGroupsUseCaseImpl(MuscleGroupRepositoryService muscleGroupRepositoryService) {
        this.muscleGroupRepositoryService = muscleGroupRepositoryService;
    }

    @Override
    public Collection<MuscleGroup> execute() {
        return muscleGroupRepositoryService.getAllMuscleGroups();
    }
}
