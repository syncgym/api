package com.syncgym.api.delivery.exercise.mappers;

import com.syncgym.api.delivery.exercise.entities.ExerciseEntity;
import com.syncgym.api.delivery.muscleGroup.mappers.MuscleGroupRepositoryMapper;
import com.syncgym.api.exercise.Exercise;
import com.syncgym.api.shared.RepositoryMapper;
import org.springframework.beans.factory.annotation.Autowired;

public class ExerciseRepositoryMapper implements RepositoryMapper<ExerciseEntity, Exercise> {

    @Autowired
    private MuscleGroupRepositoryMapper muscleGroupRepositoryMapper;

    @Override
    public ExerciseEntity mapToEntity(Exercise domain) {
        return new ExerciseEntity(
                domain.id(),
                muscleGroupRepositoryMapper.mapToEntity(domain.targetMuscleGroup()),
                domain.name(),
                domain.difficulty(),
                domain.description(),
                domain.allMuscleGroups().stream().map(muscleGroupRepositoryMapper::mapToEntity).toList()
        );
    }

    @Override
    public Exercise mapToDomain(ExerciseEntity entity) {
        return new Exercise(
                entity.getId(),
                entity.getName(),
                muscleGroupRepositoryMapper.mapToDomain(entity.getTargetMuscleGroup()),
                entity.getAllMuscleGroups().stream().map(muscleGroupRepositoryMapper::mapToDomain).toList(),
                entity.getDifficulty(),
                entity.getDescription()
        );
    }
}
