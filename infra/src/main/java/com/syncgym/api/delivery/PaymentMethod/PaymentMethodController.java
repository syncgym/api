package com.syncgym.api.delivery.PaymentMethod;

import com.syncgym.api.delivery.PaymentMethod.rest.PaymentMethodRest;
import com.syncgym.api.paymentMethod.exceptions.CreatePaymentMethodException;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.responses.SyncgymResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PaymentMethodController {

    ResponseEntity<SyncgymResponse<List<String>>> getPaymentMethods() throws SyncgymException;

    ResponseEntity<SyncgymResponse<PaymentMethodRest>> createPaymentMethod(PaymentMethodRest paymentMethodReq) throws SyncgymException, CreatePaymentMethodException;
}
