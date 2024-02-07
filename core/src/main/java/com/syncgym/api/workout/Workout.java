package com.syncgym.api.workout;

import com.syncgym.api.commonUser.CommonUser;
import com.syncgym.api.split.Split;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;

public record Workout(
        Long id,
        String name,
        Byte duration,
        Byte difficulty,
        List<Split> splits,
        CommonUser commonUser,
        Byte completedSplits,
        boolean is_active
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
