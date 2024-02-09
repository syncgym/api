package com.syncgym.api.delivery.userWorkout.impl;

import com.syncgym.api.delivery.userWorkout.mappers.UserWorkoutRepositoryMapper;
import com.syncgym.api.delivery.userWorkout.repositories.UserWorkoutRepository;
import com.syncgym.api.userWorkout.UserWorkout;
import com.syncgym.api.userWorkout.ports.UserWorkoutRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;
import java.util.Optional;

public class UserWorkoutServiceImpl implements UserWorkoutRepositoryService {

    @Autowired
    private UserWorkoutRepository userWorkoutRepository;

    @Autowired
    private UserWorkoutRepositoryMapper userWorkoutRepositoryMapper;

    @Override
    public Collection<UserWorkout> findAllWorkoutsByUserUsername(String username) {
        return userWorkoutRepository.findAllByCommonUserUserUsername(username)
                .stream().map(userWorkoutRepositoryMapper::mapToDomain).toList();
    }

    @Override
    public Optional<UserWorkout> findActiveWorkoutByUserUsername(String username) {
        return userWorkoutRepository.findByCommonUserUserUsernameAndIsActiveTrue(username)
                .map(userWorkoutRepositoryMapper::mapToDomain);
    }
}
