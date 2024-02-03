package com.syncgym.api.delivery.Subscription.rest;

import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

public record SubscriptionRest(
        @NotNull String planName,
        @NotNull String userUsername,
        @NotNull int monthsDuration
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
