package com.syncgym.api.plan.ports;

import com.syncgym.api.plan.Plan;

import java.util.Collection;

public interface PlanRepositoryService {

    Collection<Plan> getAllPlans();

    void savePlan(Plan plan);

    Boolean doesPlanNameExists(String name);
}

