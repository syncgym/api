package com.syncgym.api.delivery.plan.mappers;

import com.syncgym.api.delivery.plan.requests.PlanReq;
import com.syncgym.api.plan.Plan;
import com.syncgym.api.shared.ReqMapper;

public class PlanReqMapper implements ReqMapper<PlanReq, Plan> {

    @Override
    public Plan mapToEntity(final PlanReq req) {

        return new Plan(null, req.getName(), req.getValue());
    }

    @Override
    public PlanReq mapToReq(final Plan entity) {
        return new PlanReq(entity.getName(), entity.getValue());
    }
}
