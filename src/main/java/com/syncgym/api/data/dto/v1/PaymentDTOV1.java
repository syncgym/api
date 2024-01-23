package com.syncgym.api.data.dto.v1;

import com.syncgym.api.models.PaymentMethod;
import com.syncgym.api.models.Subscription;

import java.util.Date;

public record PaymentDTOV1(
        long id,
        PaymentMethod paymentMethod,
        Subscription subscription,
        double value,
        Date date,
        String invoice
) { }
