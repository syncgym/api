package com.syncgym.api.repositories;

import com.syncgym.api.models.Plan;
import com.syncgym.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PlanRepository extends JpaRepository<Plan, Long> {
}
