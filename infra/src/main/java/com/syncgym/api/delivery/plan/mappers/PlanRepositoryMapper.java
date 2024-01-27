package com.syncgym.api.delivery.plan.mappers;

import com.syncgym.api.delivery.plan.entities.PlanEntity;
import com.syncgym.api.plan.Plan;
import com.syncgym.api.shared.RepositoryMapper;

public class PlanRepositoryMapper implements RepositoryMapper<PlanEntity, Plan> {

    @Override
    public PlanEntity mapToTable(final Plan plan) {
        return new PlanEntity(plan.getId(), plan.getName(), parseInt(plan.getValue()));
    }

    @Override
    public Plan mapToEntity(final PlanEntity planEntity) {
        return new Plan(planEntity.getId(), planEntity.getName(), parseDouble(planEntity.getValue()));
    }

    private int parseInt(Double value) {
        return (int) Math.round(value * 100);
    }

    private Double parseDouble(int value) {
        return value / 100.0;
    }
}
