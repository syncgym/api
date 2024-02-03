package com.syncgym.api.plan.usecases.getPlanByNameUseCase;

import com.syncgym.api.plan.Plan;
import com.syncgym.api.plan.exceptions.PlanNotFoundException;

public interface GetPlanByNameUseCase {

    Plan execute(String name) throws PlanNotFoundException;
}
