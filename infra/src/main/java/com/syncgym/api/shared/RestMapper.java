package com.syncgym.api.shared;

import java.io.Serializable;

public interface RestMapper<R extends Serializable, E extends Serializable> {

    default E mapToDomain(final R rest) {
        throw new UnsupportedOperationException();
    }

    default R mapToRest(final E domain) {
        throw new UnsupportedOperationException();
    }
}