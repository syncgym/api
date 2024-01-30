package com.syncgym.api.delivery.plan.mappers;

import com.syncgym.api.delivery.plan.requests.PlanReq;
import com.syncgym.api.plan.Plan;
import com.syncgym.api.shared.ReqMapper;

public class PlanReqMapper implements ReqMapper<PlanReq, Plan> {

    @Override
    public Plan mapToEntity(final PlanReq req) {

        return new Plan(null, req.name(), parseInt(req.value()));
    }

    @Override
    public PlanReq mapToReq(final Plan entity) {
        return new PlanReq(entity.name(), parseDouble(entity.value()));
    }

    private int parseInt(Double value) {
        return (int) Math.round(value * 100);
    }

    private Double parseDouble(int value) {
        return value / 100.0;
    }
}
