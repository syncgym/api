package com.syncgym.api.delivery.split.repositories;

import com.syncgym.api.delivery.split.entities.SplitEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SplitRepository extends JpaRepository<SplitEntity, Long> {

}
