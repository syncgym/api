package com.syncgym.api.delivery.PaymentMethod.repositories;

import com.syncgym.api.delivery.PaymentMethod.entities.PaymentMethodEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PaymentMethodRepository extends JpaRepository<PaymentMethodEntity, Long> {
}
