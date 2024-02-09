package com.syncgym.api.split.usecases.getSplitByIdUseCase;

import com.syncgym.api.split.Split;
import com.syncgym.api.split.exceptions.SplitNotFoundException;
import com.syncgym.api.split.ports.SplitRepositoryService;

public class GetSplitByIdUseCaseImpl implements GetSplitByIdUseCase {

    private final SplitRepositoryService splitRepositoryService;

    public GetSplitByIdUseCaseImpl(SplitRepositoryService splitRepositoryService) {
        this.splitRepositoryService = splitRepositoryService;
    }

    @Override
    public Split getSplitById(Long id) throws SplitNotFoundException {
        return splitRepositoryService.findById(id)
                .orElseThrow(SplitNotFoundException::new);
    }
}
