package com.syncgym.api.delivery.paymentMethod.mappers;

import com.syncgym.api.delivery.paymentMethod.entities.PaymentMethodEntity;
import com.syncgym.api.paymentMethod.PaymentMethod;
import com.syncgym.api.shared.RepositoryMapper;

public class PaymentMethodRepositoryMapper implements RepositoryMapper<PaymentMethodEntity, PaymentMethod> {

    @Override
    public PaymentMethodEntity mapToTable(final PaymentMethod paymentMethod) {
        return new PaymentMethodEntity(paymentMethod.id(), paymentMethod.name());
    }

    @Override
    public PaymentMethod mapToEntity(final PaymentMethodEntity paymentMethodEntity) {
        return new PaymentMethod(paymentMethodEntity.getId(), paymentMethodEntity.getName());
    }
}
