package com.syncgym.api.delivery.Subscription;

import com.syncgym.api.delivery.Subscription.rest.SubscriptionResponseRest;
import com.syncgym.api.delivery.Subscription.rest.SubscriptionRest;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.responses.SyncgymResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface SubscriptionController {

    ResponseEntity<SyncgymResponse<List<SubscriptionResponseRest>>> getSubscriptionsByUser(String username) throws SyncgymException;

    ResponseEntity<SyncgymResponse<SubscriptionResponseRest>> getActiveSubscriptionByUser(String username) throws SyncgymException;

    ResponseEntity<SyncgymResponse<SubscriptionResponseRest>> createSubscription(SubscriptionRest subscriptionRest) throws SyncgymException;
}
