package com.syncgym.api.delivery.plan.mappers;

import com.syncgym.api.delivery.plan.entities.PlanEntity;
import com.syncgym.api.plan.Plan;
import com.syncgym.api.shared.RepositoryMapper;

public class PlanRepositoryMapper implements RepositoryMapper<PlanEntity, Plan> {

    @Override
    public PlanEntity mapToTable(final Plan plan) {
        return new PlanEntity(plan.id(), plan.name(), plan.value());
    }

    @Override
    public Plan mapToEntity(final PlanEntity planEntity) {
        return new Plan(planEntity.getId(), planEntity.getName(), planEntity.getValue());
    }
}
