package com.syncgym.api.delivery.PaymentMethod.rest;

import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

public record PaymentMethodRest(@NotNull String name) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
