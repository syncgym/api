package com.syncgym.api.delivery.plan.repositories;

import com.syncgym.api.delivery.plan.entities.PlanEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface PlanRepository extends JpaRepository<PlanEntity, Long> {

    Collection<PlanEntity> findByName(String name);
}
