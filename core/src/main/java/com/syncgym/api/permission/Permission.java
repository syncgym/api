package com.syncgym.api.permission;

import java.io.Serial;
import java.io.Serializable;

public record Permission(Long id, String description) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
