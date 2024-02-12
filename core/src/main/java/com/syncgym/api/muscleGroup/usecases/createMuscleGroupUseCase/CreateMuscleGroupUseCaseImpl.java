package com.syncgym.api.muscleGroup.usecases.createMuscleGroupUseCase;

import com.syncgym.api.muscleGroup.MuscleGroup;
import com.syncgym.api.muscleGroup.exceptions.MuscleGroupAlreadyExistsException;
import com.syncgym.api.muscleGroup.ports.MuscleGroupRepositoryService;

public class CreateMuscleGroupUseCaseImpl implements CreateMuscleGroupUseCase {

    private final MuscleGroupRepositoryService muscleGroupRepositoryService;

    public CreateMuscleGroupUseCaseImpl(MuscleGroupRepositoryService muscleGroupRepositoryService) {
        this.muscleGroupRepositoryService = muscleGroupRepositoryService;
    }

    @Override
    public MuscleGroup execute(String name) throws MuscleGroupAlreadyExistsException {
        try {
            return muscleGroupRepositoryService.createMuscleGroup(new MuscleGroup(null, name));
        } catch (Exception e) {
            throw new MuscleGroupAlreadyExistsException();
        }
    }
}
