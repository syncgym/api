package com.syncgym.api.delivery.muscleGroup.mappers;

import com.syncgym.api.delivery.muscleGroup.entities.MuscleGroupEntity;
import com.syncgym.api.muscleGroup.MuscleGroup;
import com.syncgym.api.shared.RepositoryMapper;

public class MuscleGroupRepositoryMapper implements RepositoryMapper<MuscleGroupEntity, MuscleGroup> {

    @Override
    public MuscleGroupEntity mapToEntity(final MuscleGroup domain) {
        return new MuscleGroupEntity(domain.id(), domain.name());
    }

    @Override
    public MuscleGroup mapToDomain(final MuscleGroupEntity entity) {
        return new MuscleGroup(entity.getId(), entity.getName());
    }
}
