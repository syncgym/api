package com.syncgym.api.paymentMethod;

import java.io.Serial;
import java.io.Serializable;

public record PaymentMethod(Long id, String name) implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;
}
