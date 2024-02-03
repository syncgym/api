package com.syncgym.api.delivery.MuscleGroup.mappers;

import com.syncgym.api.delivery.MuscleGroup.entities.MuscleGroupEntity;
import com.syncgym.api.muscleGroup.MuscleGroup;
import com.syncgym.api.shared.RepositoryMapper;

public class MuscleGroupRepositoryMapper implements RepositoryMapper<MuscleGroupEntity, MuscleGroup> {

    @Override
    public MuscleGroupEntity mapToTable(final MuscleGroup muscleGroup) {
        return new MuscleGroupEntity(muscleGroup.id(), muscleGroup.name());
    }

    @Override
    public MuscleGroup mapToEntity(final MuscleGroupEntity muscleGroupEntity) {
        return new MuscleGroup(muscleGroupEntity.getId(), muscleGroupEntity.getName());
    }
}
