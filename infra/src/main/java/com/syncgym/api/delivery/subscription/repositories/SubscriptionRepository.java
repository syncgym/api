package com.syncgym.api.delivery.subscription.repositories;

import com.syncgym.api.delivery.subscription.entities.SubscriptionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface SubscriptionRepository extends JpaRepository<SubscriptionEntity, Long> {

    Collection<SubscriptionEntity> findAllByCommonUserId(Long id);

    Collection<SubscriptionEntity> findAllByCommonUserUserUsername(String username);
}
