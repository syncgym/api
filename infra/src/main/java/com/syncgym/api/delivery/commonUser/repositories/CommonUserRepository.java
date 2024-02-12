package com.syncgym.api.delivery.commonUser.repositories;

import com.syncgym.api.delivery.commonUser.entities.CommonUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface CommonUserRepository extends JpaRepository<CommonUserEntity, Long> {

    Optional<CommonUserEntity> findByUserUsername(String username);
}
