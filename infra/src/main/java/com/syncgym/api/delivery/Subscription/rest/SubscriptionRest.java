package com.syncgym.api.delivery.Subscription.rest;

import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

public record SubscriptionRest(@NotNull Long planId, @NotNull Long userId) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
