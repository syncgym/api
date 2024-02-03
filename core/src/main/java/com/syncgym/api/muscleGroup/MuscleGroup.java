package com.syncgym.api.muscleGroup;

import java.io.Serial;
import java.io.Serializable;

public record MuscleGroup(Long id, String name) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
