package com.syncgym.api.shared;

import java.io.Serializable;

public interface RestMapper<R extends Serializable, E extends Serializable> {

    default E mapToEntity(final R rest) {
        throw new UnsupportedOperationException();
    }

    default R mapToRest(final E entity) {
        throw new UnsupportedOperationException();
    }
}