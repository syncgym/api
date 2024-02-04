package com.syncgym.api.delivery.exercise.rest;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record ExerciseResponseRest(
        String name,
        String targetMuscleGroup,
        List<String> allMuscleGroups,
        Byte difficulty,
        String description
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
