package com.syncgym.api.delivery.MuscleGroup.impl;

import com.syncgym.api.delivery.MuscleGroup.mappers.MuscleGroupRepositoryMapper;
import com.syncgym.api.delivery.MuscleGroup.repositories.MuscleGroupRepository;
import com.syncgym.api.muscleGroup.MuscleGroup;
import com.syncgym.api.muscleGroup.ports.MuscleGroupRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;

public class MuscleGroupServiceImpl implements MuscleGroupRepositoryService {

    @Autowired
    private MuscleGroupRepository muscleGroupRepository;

    @Autowired
    private MuscleGroupRepositoryMapper muscleGroupRepositoryMapper;

    @Override
    public Collection<MuscleGroup> getAllMuscleGroups() {
        return muscleGroupRepository.findAll()
                .stream().map(muscleGroupRepositoryMapper::mapToEntity).toList();
    }

    @Override
    public Optional<MuscleGroup> getMuscleGroupByName(String name) {
        return muscleGroupRepository.findByName(name)
                .map(muscleGroupRepositoryMapper::mapToEntity);
    }
}
