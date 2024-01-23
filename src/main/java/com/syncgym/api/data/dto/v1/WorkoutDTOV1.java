package com.syncgym.api.data.dto.v1;

import com.syncgym.api.models.Exercise;

import java.util.List;

public record WorkoutDTOV1(
        long id,
        String name,
        byte duration,
        byte difficulty,
        List<Exercise> exercises
) { }
