package com.syncgym.api.delivery.plan.requests;

import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

public record PlanReq(@NotNull String name, @NotNull Double value) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
