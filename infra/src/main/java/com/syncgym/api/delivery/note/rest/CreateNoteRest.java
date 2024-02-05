package com.syncgym.api.delivery.note.rest;

import jakarta.validation.constraints.NotNull;

import java.io.Serial;
import java.io.Serializable;

public record CreateNoteRest(
        @NotNull String userUsername,
        @NotNull String exerciseName,
        @NotNull String noteContent
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
