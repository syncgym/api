package com.syncgym.api.split;

import com.syncgym.api.exercise.Exercise;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record Split(
        Long id,
        String name,
        Byte ordination,
        List<Exercise> exercises
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
