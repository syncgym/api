package com.syncgym.api.delivery.muscleGroup.rest;

import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

public record CreateMuscleGroupReqRest(@NotNull String name) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
