package com.syncgym.api.delivery.plan.requests;

import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

public class PlanReq implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @NotNull
    private String name;

    @NotNull
    private Double value;

    public PlanReq() {
    }

    public PlanReq(final String name, final Double value) {
        this.name = name;
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public Double getValue() {
        return value;
    }
}
