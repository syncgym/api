package com.syncgym.api.delivery.plan.responses;

import com.syncgym.api.delivery.plan.rest.PlanRest;
import com.syncgym.api.shared.responses.SyncgymResponse;

public class CreatePlanResponse extends SyncgymResponse<PlanRest> {

    public CreatePlanResponse(String status, int code, String message, PlanRest data) {
        super(status, code, message, data);
    }
}
