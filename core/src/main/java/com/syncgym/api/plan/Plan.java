package com.syncgym.api.plan;

import java.io.Serial;
import java.io.Serializable;

public record Plan(
        Long id,
        String name,
        int value
) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
