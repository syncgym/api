package com.syncgym.api.paymentMethod.ports;

import com.syncgym.api.paymentMethod.PaymentMethod;

import java.util.Collection;

public interface PaymentMethodRepositoryService {

    Collection<PaymentMethod> getAllPaymentMethods();

    PaymentMethod savePaymentMethod(PaymentMethod paymentMethod);
}
