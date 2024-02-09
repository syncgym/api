package com.syncgym.api.delivery.workout.rest;

import com.syncgym.api.delivery.split.rest.SplitResponseRest;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record WorkoutResponseRest(
        String name,
        Byte duration,
        Byte difficulty,
        List<SplitResponseRest> splits
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
