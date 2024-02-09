package com.syncgym.api.split.ports;

import com.syncgym.api.split.Split;

import java.util.Optional;

public interface SplitRepositoryService {

    Optional<Split> findById(Long id);
}
