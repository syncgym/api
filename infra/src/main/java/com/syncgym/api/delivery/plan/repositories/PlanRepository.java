package com.syncgym.api.delivery.plan.repositories;

import com.syncgym.api.delivery.plan.entities.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PlanRepository extends JpaRepository<PlanEntity, Long> {

    Optional<PlanEntity> findByName(String name);
}
