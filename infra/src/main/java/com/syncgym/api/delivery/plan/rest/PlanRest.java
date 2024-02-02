package com.syncgym.api.delivery.plan.rest;

import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

public record PlanRest(@NotNull String name, @NotNull Double value) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
