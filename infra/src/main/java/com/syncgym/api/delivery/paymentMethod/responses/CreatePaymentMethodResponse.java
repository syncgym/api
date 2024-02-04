package com.syncgym.api.delivery.paymentMethod.responses;

import com.syncgym.api.delivery.paymentMethod.rest.PaymentMethodRest;
import com.syncgym.api.shared.responses.SyncgymResponse;

public class CreatePaymentMethodResponse extends SyncgymResponse<PaymentMethodRest> {

    public CreatePaymentMethodResponse(String status, int code, String message, PaymentMethodRest data) {
        super(status, code, message, data);
    }
}
