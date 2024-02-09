package com.syncgym.api.delivery.userWorkout.mappers;

import com.syncgym.api.delivery.commonUser.mappers.CommonUserRepositoryMapper;
import com.syncgym.api.delivery.userWorkout.entities.UserWorkoutEntity;
import com.syncgym.api.delivery.userWorkout.entities.UserWorkoutId;
import com.syncgym.api.delivery.workout.mappers.WorkoutRepositoryMapper;
import com.syncgym.api.shared.RepositoryMapper;
import com.syncgym.api.userWorkout.UserWorkout;
import org.springframework.beans.factory.annotation.Autowired;

public class UserWorkoutRepositoryMapper implements RepositoryMapper<UserWorkoutEntity, UserWorkout> {

    @Autowired
    private CommonUserRepositoryMapper userRepositoryMapper;

    @Autowired
    private WorkoutRepositoryMapper workoutRepositoryMapper;

    @Override
    public UserWorkoutEntity mapToEntity(final UserWorkout domain) {
        return new UserWorkoutEntity(
                new UserWorkoutId(
                        domain.commonUser().id(),
                        domain.workout().id()
                ),
                userRepositoryMapper.mapToEntity(domain.commonUser()),
                workoutRepositoryMapper.mapToEntity(domain.workout()),
                domain.completedSplits(),
                domain.isActive()
        );
    }

    @Override
    public UserWorkout mapToDomain(final UserWorkoutEntity entity) {
        return new UserWorkout(
                userRepositoryMapper.mapToDomain(entity.getCommonUser()),
                workoutRepositoryMapper.mapToDomain(entity.getWorkout()),
                entity.getCompletedSplits(),
                entity.getActive()
        );
    }
}
