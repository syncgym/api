package com.syncgym.api.delivery.plan;

import com.syncgym.api.delivery.plan.requests.PlanReq;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.responses.SyncgymResponse;

import java.util.Collection;

public interface PlanController {

    SyncgymResponse<Collection<PlanReq>> getPlans() throws SyncgymException;

    SyncgymResponse<PlanReq> createPlan(PlanReq planReq) throws SyncgymException;
}
