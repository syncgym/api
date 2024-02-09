package com.syncgym.api.delivery.userWorkout.mappers;

import com.syncgym.api.delivery.userWorkout.rest.UserWorkoutResponseRest;
import com.syncgym.api.delivery.workout.mappers.WorkoutResponseRestMapper;
import com.syncgym.api.shared.RestMapper;
import com.syncgym.api.userWorkout.UserWorkout;
import org.springframework.beans.factory.annotation.Autowired;

public class UserWorkoutResponseRestMapper implements RestMapper<UserWorkoutResponseRest, UserWorkout> {

    @Autowired
    private WorkoutResponseRestMapper workoutResponseRestMapper;

    @Override
    public UserWorkoutResponseRest mapToRest(UserWorkout domain) {
        return new UserWorkoutResponseRest(
                domain.completedSplits(),
                domain.isActive(),
                workoutResponseRestMapper.mapToRest(domain.workout())
        );
    }
}
