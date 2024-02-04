package com.syncgym.api.delivery.paymentMethod.impl;

import com.syncgym.api.delivery.paymentMethod.mappers.PaymentMethodRepositoryMapper;
import com.syncgym.api.delivery.paymentMethod.repositories.PaymentMethodRepository;
import com.syncgym.api.paymentMethod.PaymentMethod;
import com.syncgym.api.paymentMethod.ports.PaymentMethodRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.stream.Collectors;

public class PaymentMethodServiceImpl implements PaymentMethodRepositoryService {

    @Autowired
    private PaymentMethodRepository paymentMethodRepository;

    @Autowired
    private PaymentMethodRepositoryMapper paymentMethodRepositoryMapper;

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
