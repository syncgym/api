package com.syncgym.api.muscleGroup.usecases.updateMuscleGroupUseCase;

import com.syncgym.api.muscleGroup.MuscleGroup;
import com.syncgym.api.muscleGroup.exceptions.MuscleGroupNotFoundException;
import com.syncgym.api.muscleGroup.ports.MuscleGroupRepositoryService;
import com.syncgym.api.muscleGroup.usecases.getMuscleGroupByNameUseCase.GetMuscleGroupByNameUseCase;

public class UpdateMuscleGroupUseCaseImpl implements UpdateMuscleGroupUseCase {

    private final MuscleGroupRepositoryService muscleGroupRepository;

    private final GetMuscleGroupByNameUseCase getMuscleGroupByNameUseCase;

    public UpdateMuscleGroupUseCaseImpl(MuscleGroupRepositoryService muscleGroupRepository, GetMuscleGroupByNameUseCase getMuscleGroupByNameUseCase) {
        this.muscleGroupRepository = muscleGroupRepository;
        this.getMuscleGroupByNameUseCase = getMuscleGroupByNameUseCase;
    }

    @Override
    public MuscleGroup execute(String newName, String name) throws MuscleGroupNotFoundException {
        try {
            var muscleGroup = getMuscleGroupByNameUseCase.execute(name);

            return muscleGroupRepository.updateMuscleGroup(new MuscleGroup(muscleGroup.id(), newName));
        } catch (Exception e) {
            throw new MuscleGroupNotFoundException();
        }
    }
}
