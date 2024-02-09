package com.syncgym.api.delivery.userWorkout.config;

import com.syncgym.api.delivery.userWorkout.impl.UserWorkoutServiceImpl;
import com.syncgym.api.delivery.userWorkout.mappers.UserWorkoutRepositoryMapper;
import com.syncgym.api.delivery.userWorkout.mappers.UserWorkoutResponseRestMapper;
import com.syncgym.api.userWorkout.usecases.getActiveWorkoutByUserUsernameUseCase.GetActiveWorkoutByUserUsernameUseCaseImpl;
import com.syncgym.api.userWorkout.usecases.getAllWorkoutsByUserUsernameUseCase.GetAllWorkoutsByUserUsernameUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class UserWorkoutConfig {

    @Bean
    public UserWorkoutRepositoryMapper userWorkoutRepositoryMapper() {
        return new UserWorkoutRepositoryMapper();
    }

    @Bean
    public UserWorkoutResponseRestMapper userWorkoutResponseRestMapper() {
        return new UserWorkoutResponseRestMapper();
    }

    @Bean
    public UserWorkoutServiceImpl userWorkoutService() {
        return new UserWorkoutServiceImpl();
    }

    @Bean
    public GetAllWorkoutsByUserUsernameUseCaseImpl getAllWorkoutsByUserUsernameUseCase() {
        return new GetAllWorkoutsByUserUsernameUseCaseImpl(userWorkoutService());
    }

    @Bean
    public GetActiveWorkoutByUserUsernameUseCaseImpl getActiveWorkoutByUserUsernameUseCase() {
        return new GetActiveWorkoutByUserUsernameUseCaseImpl(userWorkoutService());
    }
}
