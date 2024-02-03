package com.syncgym.api.delivery.Subscription.responses;

import com.syncgym.api.delivery.Subscription.rest.SubscriptionResponseRest;
import com.syncgym.api.shared.responses.SyncgymResponse;

import java.util.List;

public class ListOfSubscriptionResponse extends SyncgymResponse<List<SubscriptionResponseRest>> {

    public ListOfSubscriptionResponse(String status, int code, String message, List<SubscriptionResponseRest> data) {
        super(status, code, message, data);
    }
}
