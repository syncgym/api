package com.syncgym.api.shared;

import java.io.Serializable;

public interface ReqMapper<R extends Serializable, E extends Serializable> {

    default E mapToEntity(final R rest) {
        throw new UnsupportedOperationException();
    }

    default R mapToReq(final E entity) {
        throw new UnsupportedOperationException();
    }
}