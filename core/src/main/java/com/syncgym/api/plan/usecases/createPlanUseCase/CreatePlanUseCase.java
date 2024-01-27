package com.syncgym.api.plan.usecases.createPlanUseCase;

import com.syncgym.api.plan.Plan;
import com.syncgym.api.plan.exceptions.PlanAlreadyExistException;

public interface CreatePlanUseCase {

    void execute(Plan plan) throws PlanAlreadyExistException;
}
