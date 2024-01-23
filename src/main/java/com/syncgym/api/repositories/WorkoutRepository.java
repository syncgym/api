package com.syncgym.api.repositories;

import com.syncgym.api.models.User;
import com.syncgym.api.models.Workout;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WorkoutRepository extends JpaRepository<Workout, Long> {
}
