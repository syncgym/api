package com.syncgym.api.delivery.paymentMethod.mappers;

import com.syncgym.api.delivery.paymentMethod.rest.PaymentMethodRest;
import com.syncgym.api.paymentMethod.PaymentMethod;
import com.syncgym.api.shared.RestMapper;

public class PaymentMethodRestMapper implements RestMapper<PaymentMethodRest, PaymentMethod> {

    @Override
    public PaymentMethod mapToDomain(final PaymentMethodRest rest) {
        return new PaymentMethod(null, rest.name());
    }

    @Override
    public PaymentMethodRest mapToRest(final PaymentMethod domain) {
        return new PaymentMethodRest(domain.name());
    }
}
