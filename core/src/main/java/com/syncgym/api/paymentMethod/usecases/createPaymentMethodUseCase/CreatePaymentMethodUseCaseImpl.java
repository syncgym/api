package com.syncgym.api.paymentMethod.usecases.createPaymentMethodUseCase;

import com.syncgym.api.paymentMethod.PaymentMethod;
import com.syncgym.api.paymentMethod.exceptions.CreatePaymentMethodException;
import com.syncgym.api.paymentMethod.ports.PaymentMethodRepositoryService;

public class CreatePaymentMethodUseCaseImpl implements CreatePaymentMethodUseCase {

    private final PaymentMethodRepositoryService paymentMethodRepositoryService;

    public CreatePaymentMethodUseCaseImpl(PaymentMethodRepositoryService paymentMethodRepositoryService) {
        this.paymentMethodRepositoryService = paymentMethodRepositoryService;
    }

    @Override
    public PaymentMethod execute(PaymentMethod paymentMethod) throws CreatePaymentMethodException {
        try {
            return paymentMethodRepositoryService.savePaymentMethod(paymentMethod);
        } catch (Exception e) {
            throw new CreatePaymentMethodException(e.getMessage());
        }
    }
}
