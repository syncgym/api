package com.syncgym.api.delivery.MuscleGroup.repositories;

import com.syncgym.api.delivery.MuscleGroup.entities.MuscleGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MuscleGroupRepository extends JpaRepository<MuscleGroupEntity, Long> {

    Optional<MuscleGroupEntity> findByName(String name);
}
