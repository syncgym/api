package com.syncgym.api.plan.usecases.createPlanUseCase;

import com.syncgym.api.plan.Plan;
import com.syncgym.api.plan.exceptions.PlanAlreadyExistException;
import com.syncgym.api.plan.ports.PlanRepositoryService;

public class CreatePlanUseCaseImpl implements CreatePlanUseCase {

    private final PlanRepositoryService planRepositoryService;

    public CreatePlanUseCaseImpl(PlanRepositoryService planRepositoryService) {
        this.planRepositoryService = planRepositoryService;
    }

    @Override
    public void execute(Plan plan) throws PlanAlreadyExistException {

        if (planRepositoryService.doesPlanNameExists(plan.name())) {
            throw new PlanAlreadyExistException();
        }

        planRepositoryService.savePlan(plan);
    }
}
