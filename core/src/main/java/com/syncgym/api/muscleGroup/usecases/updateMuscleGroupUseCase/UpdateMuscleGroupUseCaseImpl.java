package com.syncgym.api.muscleGroup.usecases.updateMuscleGroupUseCase;

import com.syncgym.api.muscleGroup.MuscleGroup;
import com.syncgym.api.muscleGroup.exceptions.MuscleGroupNotFoundException;
import com.syncgym.api.muscleGroup.ports.MuscleGroupRepositoryService;

public class UpdateMuscleGroupUseCaseImpl implements UpdateMuscleGroupUseCase {

    private final MuscleGroupRepositoryService muscleGroupRepository;

    public UpdateMuscleGroupUseCaseImpl(MuscleGroupRepositoryService muscleGroupRepository) {
        this.muscleGroupRepository = muscleGroupRepository;
    }

    @Override
    public MuscleGroup execute(String newName, String name) throws MuscleGroupNotFoundException {
        return muscleGroupRepository.updateMuscleGroup(newName, name)
                .orElseThrow(MuscleGroupNotFoundException::new);
    }
}
