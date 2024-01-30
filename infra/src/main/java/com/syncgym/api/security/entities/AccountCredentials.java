package com.syncgym.api.security.entities;

import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

public record AccountCredentials(
        @NotNull String username,
        @NotNull String password
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
