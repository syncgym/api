package com.syncgym.api.delivery.paymentMethod.mappers;

import com.syncgym.api.delivery.paymentMethod.rest.PaymentMethodRest;
import com.syncgym.api.paymentMethod.PaymentMethod;
import com.syncgym.api.shared.RestMapper;

public class PaymentMethodRestMapper implements RestMapper<PaymentMethodRest, PaymentMethod> {

    @Override
    public PaymentMethod mapToEntity(final PaymentMethodRest req) {
        return new PaymentMethod(null, req.name());
    }

    @Override
    public PaymentMethodRest mapToRest(final PaymentMethod entity) {
        return new PaymentMethodRest(entity.name());
    }
}
