package com.syncgym.api.repositories;

import com.syncgym.api.models.MuscleGroup;
import com.syncgym.api.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MuscleGroupRepository extends JpaRepository<MuscleGroup, Long> {
}
