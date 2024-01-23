package com.syncgym.api.data.dto.v1;

import com.syncgym.api.models.MuscleGroup;

import java.util.List;

public record ExerciseDTOV1(
        long id,
        String name,
        MuscleGroup targetMuscleGroup,
        byte difficulty,
        String description,
        List<MuscleGroup> muscleGroups
) { }
