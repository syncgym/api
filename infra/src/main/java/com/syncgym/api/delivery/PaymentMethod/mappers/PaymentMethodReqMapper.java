package com.syncgym.api.delivery.PaymentMethod.mappers;

import com.syncgym.api.delivery.PaymentMethod.requests.PaymentMethodReq;
import com.syncgym.api.paymentMethod.PaymentMethod;
import com.syncgym.api.shared.ReqMapper;

public class PaymentMethodReqMapper implements ReqMapper<PaymentMethodReq, PaymentMethod> {

    @Override
    public PaymentMethod mapToEntity(final PaymentMethodReq req) {
        return new PaymentMethod(null, req.name());
    }

    @Override
    public PaymentMethodReq mapToReq(final PaymentMethod entity) {
        return new PaymentMethodReq(entity.name());
    }
}
