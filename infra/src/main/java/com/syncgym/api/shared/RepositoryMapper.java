package com.syncgym.api.shared;

import java.io.Serializable;

public interface RepositoryMapper<T extends Serializable, P extends Serializable> {

    default T mapToTable(final P persistenceObject) {
        throw new UnsupportedOperationException();
    }

    default P mapToEntity(final T tableObject) {
        throw new UnsupportedOperationException();
    }
}