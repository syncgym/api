package com.syncgym.api.paymentMethod.usecases.getAllPaymentMethodsUseCase;

import com.syncgym.api.paymentMethod.PaymentMethod;
import com.syncgym.api.paymentMethod.ports.PaymentMethodRepositoryService;

import java.util.Collection;

public class GetAllPaymentMethodsUseCaseImpl implements GetAllPaymentMethodsUseCase {

    private final PaymentMethodRepositoryService paymentMethodRepositoryService;

    public GetAllPaymentMethodsUseCaseImpl(PaymentMethodRepositoryService paymentMethodRepositoryService) {
        this.paymentMethodRepositoryService = paymentMethodRepositoryService;
    }

    @Override
    public Collection<PaymentMethod> execute() {
        return paymentMethodRepositoryService.getAllPaymentMethods();
    }
}
