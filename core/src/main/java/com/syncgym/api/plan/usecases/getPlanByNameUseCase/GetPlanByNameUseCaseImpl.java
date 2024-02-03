package com.syncgym.api.plan.usecases.getPlanByNameUseCase;

import com.syncgym.api.plan.Plan;
import com.syncgym.api.plan.exceptions.PlanNotFoundException;
import com.syncgym.api.plan.ports.PlanRepositoryService;

public class GetPlanByNameUseCaseImpl implements GetPlanByNameUseCase {

    private final PlanRepositoryService planRepositoryService;

    public GetPlanByNameUseCaseImpl(PlanRepositoryService planRepositoryService) {
        this.planRepositoryService = planRepositoryService;
    }

    @Override
    public Plan execute(String name) throws PlanNotFoundException {
        return planRepositoryService.getPlanByName(name)
                .orElseThrow(PlanNotFoundException::new);
    }
}
