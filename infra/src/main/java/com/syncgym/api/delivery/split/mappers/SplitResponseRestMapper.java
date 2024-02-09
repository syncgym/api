package com.syncgym.api.delivery.split.mappers;

import com.syncgym.api.delivery.exercise.mappers.ExerciseResponseRestMapper;
import com.syncgym.api.delivery.split.rest.SplitResponseRest;
import com.syncgym.api.shared.RestMapper;
import com.syncgym.api.split.Split;
import org.springframework.beans.factory.annotation.Autowired;

public class SplitResponseRestMapper implements RestMapper<SplitResponseRest, Split> {

    @Autowired
    private ExerciseResponseRestMapper exerciseResponseRestMapper;

    @Override
    public SplitResponseRest mapToRest(Split domain) {
        return new SplitResponseRest(
                domain.name(),
                domain.ordination(),
                domain.exercises().stream().map(exerciseResponseRestMapper::mapToRest).toList()
        );
    }
}
