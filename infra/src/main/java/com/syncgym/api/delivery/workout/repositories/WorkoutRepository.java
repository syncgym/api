package com.syncgym.api.delivery.workout.repositories;

import com.syncgym.api.delivery.workout.entities.WorkoutEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<WorkoutEntity, Long> {

}
