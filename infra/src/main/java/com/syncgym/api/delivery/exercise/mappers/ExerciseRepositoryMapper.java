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
    public ExerciseEntity mapToTable(Exercise persistenceObject) {
        return new ExerciseEntity(
                persistenceObject.id(),
                muscleGroupRepositoryMapper.mapToTable(persistenceObject.targetMuscleGroup()),
                persistenceObject.name(),
                persistenceObject.difficulty(),
                persistenceObject.description(),
                persistenceObject.allMuscleGroups().stream().map(muscleGroupRepositoryMapper::mapToTable).toList()
        );
    }

    @Override
    public Exercise mapToEntity(ExerciseEntity tableObject) {
        return new Exercise(
                tableObject.getId(),
                tableObject.getName(),
                muscleGroupRepositoryMapper.mapToEntity(tableObject.getTargetMuscleGroup()),
                tableObject.getAllMuscleGroups().stream().map(muscleGroupRepositoryMapper::mapToEntity).toList(),
                tableObject.getDifficulty(),
                tableObject.getDescription()
        );
    }
}
