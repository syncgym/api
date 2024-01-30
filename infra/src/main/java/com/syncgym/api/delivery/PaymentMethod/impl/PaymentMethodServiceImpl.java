package com.syncgym.api.delivery.PaymentMethod.impl;

import com.syncgym.api.delivery.PaymentMethod.mappers.PaymentMethodRepositoryMapper;
import com.syncgym.api.delivery.PaymentMethod.repositories.PaymentMethodRepository;
import com.syncgym.api.paymentMethod.PaymentMethod;
import com.syncgym.api.paymentMethod.ports.PaymentMethodRepositoryService;

import java.util.Collection;
import java.util.stream.Collectors;

public class PaymentMethodServiceImpl implements PaymentMethodRepositoryService {

    private final PaymentMethodRepository paymentMethodRepository;

    private final PaymentMethodRepositoryMapper paymentMethodRepositoryMapper;

    public PaymentMethodServiceImpl(PaymentMethodRepository paymentMethodRepository, PaymentMethodRepositoryMapper paymentMethodRepositoryMapper) {
        this.paymentMethodRepository = paymentMethodRepository;
        this.paymentMethodRepositoryMapper = paymentMethodRepositoryMapper;
    }

    @Override
    public Collection<PaymentMethod> getAllPaymentMethods() {
        return paymentMethodRepository.findAll()
                .stream().map(paymentMethodRepositoryMapper::mapToEntity).collect(Collectors.toList());
    }

    @Override
    public PaymentMethod savePaymentMethod(PaymentMethod paymentMethod) {
        return paymentMethodRepositoryMapper
                .mapToEntity(paymentMethodRepository.save(paymentMethodRepositoryMapper.mapToTable(paymentMethod)));
    }
}
