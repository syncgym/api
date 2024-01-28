package com.syncgym.api.delivery.plan;

import com.syncgym.api.delivery.plan.requests.PlanReq;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.responses.SyncgymResponse;
import org.springframework.http.ResponseEntity;

public interface PlanController {

    ResponseEntity<SyncgymResponse<?>> getPlans() throws SyncgymException;

    ResponseEntity<SyncgymResponse<?>> createPlan(PlanReq planReq) throws SyncgymException;
}
