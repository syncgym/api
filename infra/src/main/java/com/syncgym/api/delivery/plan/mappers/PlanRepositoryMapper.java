package com.syncgym.api.delivery.plan.mappers;

import com.syncgym.api.delivery.plan.entities.PlanEntity;
import com.syncgym.api.plan.Plan;
import com.syncgym.api.shared.RepositoryMapper;

public class PlanRepositoryMapper implements RepositoryMapper<PlanEntity, Plan> {

    @Override
    public PlanEntity mapToEntity(final Plan domain) {
        return new PlanEntity(domain.id(), domain.name(), domain.value());
    }

    @Override
    public Plan mapToDomain(final PlanEntity entity) {
        return new Plan(entity.getId(), entity.getName(), entity.getValue());
    }
}
