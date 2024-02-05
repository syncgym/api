package com.syncgym.api.note;

import com.syncgym.api.commonUser.CommonUser;
import com.syncgym.api.exercise.Exercise;

import java.io.Serial;
import java.io.Serializable;
import java.util.Date;

public record Note(
        Long id,
        CommonUser commonUser,
        Exercise exercise,
        String description,
        Date date
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
