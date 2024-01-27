package com.syncgym.api.plan.usecases.getAllPlansUseCase;

import com.syncgym.api.plan.Plan;
import com.syncgym.api.plan.ports.PlanRepositoryService;

import java.util.Collection;

public class GetAllPlansUseCaseImpl implements GetAllPlansUseCase {

    private final PlanRepositoryService planRepositoryService;

    public GetAllPlansUseCaseImpl(PlanRepositoryService planRepositoryService) {
        this.planRepositoryService = planRepositoryService;
    }

    @Override
    public Collection<Plan> execute() {
        return planRepositoryService.getAllPlans();
    }
}
