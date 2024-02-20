package com.syncgym.api.muscleGroup.usecases.deleteMuscleGroupUseCase;

import com.syncgym.api.muscleGroup.exceptions.MuscleGroupDependentItemsExistException;
import com.syncgym.api.muscleGroup.exceptions.MuscleGroupNotFoundException;
import com.syncgym.api.muscleGroup.ports.MuscleGroupRepositoryService;
import com.syncgym.api.muscleGroup.usecases.getMuscleGroupByNameUseCase.GetMuscleGroupByNameUseCase;

public class DeleteMuscleGroupUseCaseImpl implements DeleteMuscleGroupUseCase {

    private final MuscleGroupRepositoryService muscleGroupRepository;

    private final GetMuscleGroupByNameUseCase getMuscleGroupByNameUseCase;

    public DeleteMuscleGroupUseCaseImpl(MuscleGroupRepositoryService muscleGroupRepository, GetMuscleGroupByNameUseCase getMuscleGroupByNameUseCase) {
        this.muscleGroupRepository = muscleGroupRepository;
        this.getMuscleGroupByNameUseCase = getMuscleGroupByNameUseCase;
    }

    @Override
    public void execute(String name) throws MuscleGroupNotFoundException, MuscleGroupDependentItemsExistException {
        var muscleGroup = getMuscleGroupByNameUseCase.execute(name);
        try {
            muscleGroupRepository.deleteMuscleGroup(muscleGroup);
        } catch (Exception e) {
            throw new MuscleGroupDependentItemsExistException();
        }
    }
}
