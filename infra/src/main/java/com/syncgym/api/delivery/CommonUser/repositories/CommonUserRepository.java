package com.syncgym.api.delivery.CommonUser.repositories;

import com.syncgym.api.delivery.CommonUser.entities.CommonUserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommonUserRepository extends JpaRepository<CommonUserEntity, Long> {
}
