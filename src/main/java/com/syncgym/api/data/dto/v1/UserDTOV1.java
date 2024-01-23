package com.syncgym.api.data.dto.v1;

import com.syncgym.api.enums.Gender;
import com.syncgym.api.models.Workout;

import java.util.Date;
import java.util.List;

public record UserDTOV1(
        long id,
        String username,
        String password,
        String firstName,
        String lastName,
        Date dateOfBirth,
        Gender gender,
        String email,
        List<Workout> workouts
) { }
