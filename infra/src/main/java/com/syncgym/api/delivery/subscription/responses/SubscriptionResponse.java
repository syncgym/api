package com.syncgym.api.delivery.subscription.responses;

import com.syncgym.api.delivery.subscription.rest.SubscriptionResponseRest;
import com.syncgym.api.shared.responses.SyncgymResponse;

public class SubscriptionResponse extends SyncgymResponse<SubscriptionResponseRest> {

    public SubscriptionResponse(String status, int code, String message, SubscriptionResponseRest data) {
        super(status, code, message, data);
    }
}
