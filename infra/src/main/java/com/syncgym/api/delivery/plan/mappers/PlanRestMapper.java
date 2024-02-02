package com.syncgym.api.delivery.plan.mappers;

import com.syncgym.api.delivery.plan.rest.PlanRest;
import com.syncgym.api.plan.Plan;
import com.syncgym.api.shared.RestMapper;

public class PlanRestMapper implements RestMapper<PlanRest, Plan> {

    @Override
    public Plan mapToEntity(final PlanRest rest) {
        return new Plan(null, rest.name(), parseInt(rest.value()));
    }

    @Override
    public PlanRest mapToRest(final Plan entity) {
        return new PlanRest(entity.name(), parseDouble(entity.value()));
    }

    private int parseInt(Double value) {
        return (int) Math.round(value * 100);
    }

    private Double parseDouble(int value) {
        return value / 100.0;
    }
}
