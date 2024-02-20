package com.syncgym.api.delivery.muscleGroup.repositories;

import com.syncgym.api.delivery.muscleGroup.entities.MuscleGroupEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface MuscleGroupRepository extends JpaRepository<MuscleGroupEntity, Long> {

    Optional<MuscleGroupEntity> findByName(String name);

    @Query("UPDATE MuscleGroupEntity m SET m.name = ?2 WHERE m.name = ?1")
    Optional<MuscleGroupEntity> updateByName(String name, String newName);

    void deleteByName(String name);
}
