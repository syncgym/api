package com.syncgym.api.delivery.PaymentMethod;

import com.syncgym.api.delivery.PaymentMethod.requests.PaymentMethodReq;
import com.syncgym.api.paymentMethod.exceptions.CreatePaymentMethodException;
import com.syncgym.api.shared.exceptions.SyncgymException;
import com.syncgym.api.shared.responses.SyncgymResponse;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface PaymentMethodController {

    ResponseEntity<SyncgymResponse<List<String>>> getPaymentMethods() throws SyncgymException;

    ResponseEntity<SyncgymResponse<PaymentMethodReq>> createPaymentMethod(PaymentMethodReq paymentMethodReq) throws SyncgymException, CreatePaymentMethodException;
}
