package com.syncgym.api.delivery.permission.repositories;

import com.syncgym.api.delivery.permission.entities.PermissionEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PermissionRepository extends JpaRepository<PermissionEntity, Long> {

    Optional<PermissionEntity> findByDescription(String description);
}
