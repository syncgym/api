package com.syncgym.api.delivery.paymentMethod.repositories;

import com.syncgym.api.delivery.paymentMethod.entities.PaymentMethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethodEntity, Long> {
}
