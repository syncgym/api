package com.syncgym.api.exercise;

import com.syncgym.api.muscleGroup.MuscleGroup;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record Exercise(
        Long id,
        String name,
        MuscleGroup targetMuscleGroup,
        List<MuscleGroup> allMuscleGroups,
        Byte difficulty,
        String description
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
