package com.syncgym.api.delivery.PaymentMethod.requests;

import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

public record PaymentMethodReq(@NotNull String name) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
