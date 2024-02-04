package com.syncgym.api.delivery.paymentMethod.mappers;

import com.syncgym.api.delivery.paymentMethod.entities.PaymentMethodEntity;
import com.syncgym.api.paymentMethod.PaymentMethod;
import com.syncgym.api.shared.RepositoryMapper;

public class PaymentMethodRepositoryMapper implements RepositoryMapper<PaymentMethodEntity, PaymentMethod> {

    @Override
    public PaymentMethodEntity mapToEntity(final PaymentMethod domain) {
        return new PaymentMethodEntity(domain.id(), domain.name());
    }

    @Override
    public PaymentMethod mapToDomain(final PaymentMethodEntity entity) {
        return new PaymentMethod(entity.getId(), entity.getName());
    }
}
