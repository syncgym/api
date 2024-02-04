package com.syncgym.api.delivery.commonUser.rest;

import com.syncgym.api.commonUser.enums.Gender;
import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public record CommonUserResponseRest(
        @NotNull String username,
        @NotNull String firstName,
        @NotNull String lastName,
        @NotNull Gender gender,
        @NotNull String email,
        @NotNull Date dateOfBirth
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
