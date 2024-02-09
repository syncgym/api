package com.syncgym.api.delivery.split.rest;

import com.syncgym.api.delivery.exercise.rest.ExerciseResponseRest;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record SplitResponseRest(
        String name,
        Byte ordination,
        List<ExerciseResponseRest> exercises
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
