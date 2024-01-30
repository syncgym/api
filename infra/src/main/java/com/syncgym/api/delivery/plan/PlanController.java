package com.syncgym.api.delivery.plan;

import com.syncgym.api.delivery.plan.requests.PlanReq;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.responses.SyncgymResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PlanController {

    ResponseEntity<SyncgymResponse<List<String>>> getPlans() throws SyncgymException;

    ResponseEntity<SyncgymResponse<PlanReq>> createPlan(PlanReq planReq) throws SyncgymException;
}
