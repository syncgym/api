package com.syncgym.api.delivery.PaymentMethod.responses;

import com.syncgym.api.delivery.PaymentMethod.requests.PaymentMethodReq;
import com.syncgym.api.shared.responses.SyncgymResponse;

public class CreatePaymentMethodResponse extends SyncgymResponse<PaymentMethodReq> {

    public CreatePaymentMethodResponse(String status, int code, String message, PaymentMethodReq data) {
        super(status, code, message, data);
    }
}
