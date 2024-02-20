package com.syncgym.api.delivery.muscleGroup.repositories;

import com.syncgym.api.delivery.muscleGroup.entities.MuscleGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface MuscleGroupRepository extends JpaRepository<MuscleGroupEntity, Long> {

    Optional<MuscleGroupEntity> findByName(String name);
}
