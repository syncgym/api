package com.syncgym.api.delivery.muscleGroup.config;

import com.syncgym.api.delivery.muscleGroup.impl.MuscleGroupServiceImpl;
import com.syncgym.api.delivery.muscleGroup.mappers.MuscleGroupRepositoryMapper;
import com.syncgym.api.muscleGroup.usecases.createMuscleGroupUseCase.CreateMuscleGroupUseCaseImpl;
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

    @Bean
    public CreateMuscleGroupUseCaseImpl createMuscleGroupUseCase() {
        return new CreateMuscleGroupUseCaseImpl(muscleGroupService());
    }
}
