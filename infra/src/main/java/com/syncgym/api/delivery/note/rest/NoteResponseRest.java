package com.syncgym.api.delivery.note.rest;

import com.syncgym.api.delivery.exercise.rest.ExerciseResponseRest;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public record NoteResponseRest(
        Long id,
        ExerciseResponseRest exercise,
        String description,
        Date date
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
