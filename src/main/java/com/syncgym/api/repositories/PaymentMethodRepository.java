package com.syncgym.api.repositories;

import com.syncgym.api.models.Payment;
import com.syncgym.api.models.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodRepository extends JpaRepository<PaymentMethod, Long> {
}
