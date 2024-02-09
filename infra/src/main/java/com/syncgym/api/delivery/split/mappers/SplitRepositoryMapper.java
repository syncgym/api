package com.syncgym.api.delivery.split.mappers;

import com.syncgym.api.delivery.exercise.mappers.ExerciseRepositoryMapper;
import com.syncgym.api.delivery.split.entities.SplitEntity;
import com.syncgym.api.shared.RepositoryMapper;
import com.syncgym.api.split.Split;
import org.springframework.beans.factory.annotation.Autowired;

public class SplitRepositoryMapper implements RepositoryMapper<SplitEntity, Split> {

    @Autowired
    private ExerciseRepositoryMapper exerciseRepositoryMapper;

    @Override
    public SplitEntity mapToEntity(final Split domain) {
        return new SplitEntity(
                domain.id(),
                domain.name(),
                domain.ordination(),
                domain.exercises().stream().map(exerciseRepositoryMapper::mapToEntity).toList()
        );
    }

    @Override
    public Split mapToDomain(final SplitEntity entity) {
        return new Split(
                entity.getId(),
                entity.getName(),
                entity.getOrdination(),
                entity.getExercises().stream().map(exerciseRepositoryMapper::mapToDomain).toList()
        );
    }
}
