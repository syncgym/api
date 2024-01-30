package com.syncgym.api.paymentMethod.usecases.getAllPaymentMethodsUseCase;

import com.syncgym.api.paymentMethod.PaymentMethod;

import java.util.Collection;

public interface GetAllPaymentMethodsUseCase {

    Collection<PaymentMethod> execute();
}
