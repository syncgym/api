package com.syncgym.api.delivery.workout.mappers;

import com.syncgym.api.delivery.split.entities.SplitEntity;
import com.syncgym.api.delivery.split.mappers.SplitRepositoryMapper;
import com.syncgym.api.delivery.workout.entities.WorkoutEntity;
import com.syncgym.api.shared.RepositoryMapper;
import com.syncgym.api.split.Split;
import com.syncgym.api.workout.Workout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;

public class WorkoutRepositoryMapper implements RepositoryMapper<WorkoutEntity, Workout> {

    @Autowired
    private SplitRepositoryMapper splitRepositoryMapper;


    @Override
    public WorkoutEntity mapToEntity(final Workout domain) {
        return new WorkoutEntity(
                domain.id(),
                domain.name(),
                domain.duration(),
                domain.difficulty(),
                domain.splits().stream().map(splitRepositoryMapper::mapToEntity)
                        .sorted(Comparator.comparing(SplitEntity::getOrdination)).toList()
        );
    }

    @Override
    public Workout mapToDomain(final WorkoutEntity entity) {
        return new Workout(
                entity.getId(),
                entity.getName(),
                entity.getDuration(),
                entity.getDifficulty(),
                entity.getSplits().stream().map(splitRepositoryMapper::mapToDomain)
                        .sorted(Comparator.comparing(Split::ordination)).toList()
        );
    }
}
