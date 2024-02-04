package com.syncgym.api.shared;

import java.io.Serializable;

public interface RepositoryMapper<T extends Serializable, P extends Serializable> {

    default T mapToEntity(final P domain) {
        throw new UnsupportedOperationException();
    }

    default P mapToDomain(final T entity) {
        throw new UnsupportedOperationException();
    }
}