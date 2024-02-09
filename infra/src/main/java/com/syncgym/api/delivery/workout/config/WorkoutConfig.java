package com.syncgym.api.delivery.workout.config;

import com.syncgym.api.delivery.workout.impl.WorkoutServiceImpl;
import com.syncgym.api.delivery.workout.mappers.WorkoutRepositoryMapper;
import com.syncgym.api.delivery.workout.mappers.WorkoutResponseRestMapper;
import com.syncgym.api.workout.usecases.getAllWorkoutsUseCase.GetAllWorkoutsUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class WorkoutConfig {

    @Bean
    public WorkoutRepositoryMapper workoutRepositoryMapper() {
        return new WorkoutRepositoryMapper();
    }

    @Bean
    public WorkoutResponseRestMapper workoutResponseRestMapper() {
        return new WorkoutResponseRestMapper();
    }

    @Bean
    public WorkoutServiceImpl workoutServiceImpl() {
        return new WorkoutServiceImpl();
    }

    @Bean
    public GetAllWorkoutsUseCaseImpl getAllWorkoutsUseCase() {
        return new GetAllWorkoutsUseCaseImpl(workoutServiceImpl());
    }
}
