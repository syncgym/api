package com.syncgym.api.data.dto.v1;

import com.syncgym.api.models.Exercise;
import com.syncgym.api.models.User;

import java.util.Date;

public record NoteDTOV1(
        long id,
        User user,
        Exercise exercise,
        String description,
        Date date
) { }
