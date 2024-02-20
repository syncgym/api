package com.syncgym.api.muscleGroup.usecases.getMuscleGroupByNameUseCase;

import com.syncgym.api.muscleGroup.MuscleGroup;
import com.syncgym.api.muscleGroup.exceptions.MuscleGroupNotFoundException;
import com.syncgym.api.muscleGroup.ports.MuscleGroupRepositoryService;

public class GetMuscleGroupByNameUseCaseImpl implements GetMuscleGroupByNameUseCase {

    private final MuscleGroupRepositoryService muscleGroupRepositoryService;

    public GetMuscleGroupByNameUseCaseImpl(MuscleGroupRepositoryService muscleGroupRepositoryService) {
        this.muscleGroupRepositoryService = muscleGroupRepositoryService;
    }

    @Override
    public MuscleGroup execute(String name) throws MuscleGroupNotFoundException {
        return muscleGroupRepositoryService.getMuscleGroupByName(name)
                .orElseThrow(MuscleGroupNotFoundException::new);
    }
}
