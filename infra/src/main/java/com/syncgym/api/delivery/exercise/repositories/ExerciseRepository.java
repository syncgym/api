package com.syncgym.api.delivery.exercise.repositories;

import com.syncgym.api.delivery.exercise.entities.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Long> {

    Collection<ExerciseEntity> findAllByTargetMuscleGroupName(String name);

    Collection<ExerciseEntity> findAllByAllMuscleGroupsName(String name);

    Optional<ExerciseEntity> findByName(String name);
}
