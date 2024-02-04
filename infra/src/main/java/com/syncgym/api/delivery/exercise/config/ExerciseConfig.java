package com.syncgym.api.delivery.exercise.config;

import com.syncgym.api.delivery.exercise.impl.ExerciseServiceImpl;
import com.syncgym.api.delivery.exercise.mappers.ExerciseRepositoryMapper;
import com.syncgym.api.delivery.exercise.mappers.ExerciseResponseRestMapper;
import com.syncgym.api.exercise.usecases.getAllExercisesByMuscleGroupUseCase.GetAllExercisesByMuscleGroupImpl;
import com.syncgym.api.exercise.usecases.getAllExercisesByTargetMuscleGroupUseCase.GetAllExercisesByTargetMuscleGroupImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ExerciseConfig {

    @Bean
    public ExerciseRepositoryMapper exerciseRepositoryMapper() {
        return new ExerciseRepositoryMapper();
    }

    @Bean
    public ExerciseResponseRestMapper exerciseResponseRestMapper() {
        return new ExerciseResponseRestMapper();
    }

    @Bean
    public ExerciseServiceImpl exerciseService() {
        return new ExerciseServiceImpl();
    }

    @Bean
    public GetAllExercisesByMuscleGroupImpl getAllExercisesByMuscleGroup() {
        return new GetAllExercisesByMuscleGroupImpl(exerciseService());
    }

    @Bean
    public GetAllExercisesByTargetMuscleGroupImpl getAllExercisesByTargetMuscleGroup() {
        return new GetAllExercisesByTargetMuscleGroupImpl(exerciseService());
    }
}
