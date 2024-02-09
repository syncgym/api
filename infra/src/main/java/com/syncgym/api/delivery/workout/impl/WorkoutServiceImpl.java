package com.syncgym.api.delivery.workout.impl;

import com.syncgym.api.delivery.workout.mappers.WorkoutRepositoryMapper;
import com.syncgym.api.delivery.workout.repositories.WorkoutRepository;
import com.syncgym.api.workout.Workout;
import com.syncgym.api.workout.ports.WorkoutRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class WorkoutServiceImpl implements WorkoutRepositoryService {

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private WorkoutRepositoryMapper workoutRepositoryMapper;

    @Override
    public Collection<Workout> findAllWorkouts() {
        return workoutRepository.findAll()
                .stream().map(workoutRepositoryMapper::mapToDomain).toList();
    }
}
