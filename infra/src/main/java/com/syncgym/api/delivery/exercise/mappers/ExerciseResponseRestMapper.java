package com.syncgym.api.delivery.exercise.mappers;

import com.syncgym.api.delivery.exercise.rest.ExerciseResponseRest;
import com.syncgym.api.exercise.Exercise;
import com.syncgym.api.muscleGroup.MuscleGroup;
import com.syncgym.api.shared.RestMapper;

public class ExerciseResponseRestMapper implements RestMapper<ExerciseResponseRest, Exercise> {

    @Override
    public ExerciseResponseRest mapToRest(Exercise domain) {
        return new ExerciseResponseRest(
                domain.name(),
                domain.targetMuscleGroup().name(),
                domain.allMuscleGroups().stream().map(MuscleGroup::name).toList(),
                domain.difficulty(),
                domain.description()
        );
    }
}
