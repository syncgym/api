package com.syncgym.api.muscleGroup.usecases.deleteMuscleGroupUseCase;

import com.syncgym.api.muscleGroup.exceptions.MuscleGroupNotFoundException;
import com.syncgym.api.muscleGroup.ports.MuscleGroupRepositoryService;

public class DeleteMuscleGroupUseCaseImpl implements DeleteMuscleGroupUseCase {

    private final MuscleGroupRepositoryService muscleGroupRepository;

    public DeleteMuscleGroupUseCaseImpl(MuscleGroupRepositoryService muscleGroupRepository) {
        this.muscleGroupRepository = muscleGroupRepository;
    }

    @Override
    public void execute(String name) throws MuscleGroupNotFoundException {
        try {
            muscleGroupRepository.deleteMuscleGroup(name);
        } catch (Exception e) {
            throw new MuscleGroupNotFoundException();
        }
    }
}
