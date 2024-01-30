package com.syncgym.api.delivery.plan.responses;

import com.syncgym.api.delivery.plan.requests.PlanReq;
import com.syncgym.api.shared.responses.SyncgymResponse;

public class CreatePlanResponse extends SyncgymResponse<PlanReq> {

    public CreatePlanResponse(String status, int code, String message, PlanReq data) {
        super(status, code, message, data);
    }
}
