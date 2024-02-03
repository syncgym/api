package com.syncgym.api.delivery.Subscription.responses;

import com.syncgym.api.delivery.Subscription.rest.SubscriptionResponseRest;
import com.syncgym.api.shared.responses.SyncgymResponse;

public class SubscriptionResponse extends SyncgymResponse<SubscriptionResponseRest> {

    public SubscriptionResponse(String status, int code, String message, SubscriptionResponseRest data) {
        super(status, code, message, data);
    }
}
