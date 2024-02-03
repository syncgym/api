package com.syncgym.api.delivery.MuscleGroup.config;

import com.syncgym.api.delivery.MuscleGroup.impl.MuscleGroupServiceImpl;
import com.syncgym.api.delivery.MuscleGroup.mappers.MuscleGroupRepositoryMapper;
import com.syncgym.api.muscleGroup.usecases.getAllMuscleGroupsUseCase.GetAllMuscleGroupsUseCaseImpl;
import com.syncgym.api.muscleGroup.usecases.getMuscleGroupByNameUseCase.GetMuscleGroupByNameUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MuscleGroupConfig {

    @Bean
    public MuscleGroupRepositoryMapper muscleGroupRepositoryMapper() {
        return new MuscleGroupRepositoryMapper();
    }

    @Bean
    public MuscleGroupServiceImpl muscleGroupService() {
        return new MuscleGroupServiceImpl();
    }

    @Bean
    public GetAllMuscleGroupsUseCaseImpl getAllMuscleGroupsUseCase() {
        return new GetAllMuscleGroupsUseCaseImpl(muscleGroupService());
    }

    @Bean
    public GetMuscleGroupByNameUseCaseImpl getMuscleGroupByNameUseCase() {
        return new GetMuscleGroupByNameUseCaseImpl(muscleGroupService());
    }
}
