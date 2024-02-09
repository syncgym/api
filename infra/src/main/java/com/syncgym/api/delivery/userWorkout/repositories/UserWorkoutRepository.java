package com.syncgym.api.delivery.userWorkout.repositories;

import com.syncgym.api.delivery.userWorkout.entities.UserWorkoutEntity;
import com.syncgym.api.delivery.userWorkout.entities.UserWorkoutId;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;
import java.util.Optional;

public interface UserWorkoutRepository extends JpaRepository<UserWorkoutEntity, UserWorkoutId> {

    Optional<UserWorkoutEntity> findByCommonUserUserUsernameAndIsActiveTrue(String username);

    Collection<UserWorkoutEntity> findAllByCommonUserUserUsername(String username);
}
