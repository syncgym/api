package com.syncgym.api.delivery.paymentMethod.responses;

import com.syncgym.api.shared.responses.SyncgymResponse;

import java.util.List;

public class GetPaymentMethodsResponse extends SyncgymResponse<List<String>> {

    public GetPaymentMethodsResponse(String status, int code, String message, List<String> data) {
        super(status, code, message, data);
    }
}
