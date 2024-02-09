package com.syncgym.api.split.usecases.getSplitByIdUseCase;

import com.syncgym.api.split.Split;
import com.syncgym.api.split.exceptions.SplitNotFoundException;

public interface GetSplitByIdUseCase {

    Split getSplitById(Long id) throws SplitNotFoundException;
}
