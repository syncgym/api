package com.syncgym.api.paymentMethod.usecases.createPaymentMethodUseCase;

import com.syncgym.api.paymentMethod.PaymentMethod;
import com.syncgym.api.paymentMethod.exceptions.CreatePaymentMethodException;

public interface CreatePaymentMethodUseCase {

    PaymentMethod execute(PaymentMethod paymentMethod) throws CreatePaymentMethodException;
}
