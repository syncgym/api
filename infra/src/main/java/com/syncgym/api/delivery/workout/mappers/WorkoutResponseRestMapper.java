package com.syncgym.api.delivery.workout.mappers;

import com.syncgym.api.delivery.split.mappers.SplitResponseRestMapper;
import com.syncgym.api.delivery.split.rest.SplitResponseRest;
import com.syncgym.api.delivery.workout.rest.WorkoutResponseRest;
import com.syncgym.api.shared.RestMapper;
import com.syncgym.api.workout.Workout;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Comparator;

public class WorkoutResponseRestMapper implements RestMapper<WorkoutResponseRest, Workout> {

    @Autowired
    private SplitResponseRestMapper splitResponseRestMapper;

    @Override
    public WorkoutResponseRest mapToRest(Workout domain) {
        return new WorkoutResponseRest(
                domain.name(),
                domain.duration(),
                domain.difficulty(),
                domain.splits().stream().map(splitResponseRestMapper::mapToRest)
                        .sorted(Comparator.comparing(SplitResponseRest::ordination)).toList()
        );
    }
}
