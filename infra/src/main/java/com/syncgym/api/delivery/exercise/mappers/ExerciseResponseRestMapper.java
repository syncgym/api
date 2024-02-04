package com.syncgym.api.delivery.exercise.mappers;

import com.syncgym.api.delivery.exercise.rest.ExerciseResponseRest;
import com.syncgym.api.exercise.Exercise;
import com.syncgym.api.muscleGroup.MuscleGroup;
import com.syncgym.api.shared.RestMapper;

public class ExerciseResponseRestMapper implements RestMapper<ExerciseResponseRest, Exercise> {

    @Override
    public ExerciseResponseRest mapToRest(Exercise entity) {
        return new ExerciseResponseRest(
                entity.name(),
                entity.targetMuscleGroup().name(),
                entity.allMuscleGroups().stream().map(MuscleGroup::name).toList(),
                entity.difficulty(),
                entity.description()
        );
    }
}
