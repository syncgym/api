package com.syncgym.api.delivery.user.repositories;

import com.syncgym.api.delivery.user.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

    UserDetails findByUsername(String username);

    @Query("SELECT u FROM UserEntity u WHERE u.username = ?1")
    Optional<UserEntity> findUserByUsername(String username);
}
