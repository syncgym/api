package com.syncgym.api.plan.usecases.getAllPlansUseCase;

import com.syncgym.api.plan.Plan;

import java.util.Collection;

public interface GetAllPlansUseCase {

    Collection<Plan> execute();
}
