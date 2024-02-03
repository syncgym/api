package com.syncgym.api.plan.ports;

import com.syncgym.api.plan.Plan;

import java.util.Collection;
import java.util.Optional;

public interface PlanRepositoryService {

    Collection<Plan> getAllPlans();

    Optional<Plan> getPlanByName(String name);

    void savePlan(Plan plan);

    Boolean doesPlanNameExists(String name);
}

