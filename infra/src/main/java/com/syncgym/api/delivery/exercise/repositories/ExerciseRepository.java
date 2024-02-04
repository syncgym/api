package com.syncgym.api.delivery.exercise.repositories;

import com.syncgym.api.delivery.exercise.entities.ExerciseEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface ExerciseRepository extends JpaRepository<ExerciseEntity, Long> {

    Collection<ExerciseEntity> findAllByTargetMuscleGroupName(String name);

    Collection<ExerciseEntity> findAllByAllMuscleGroupsName(String name);
}
