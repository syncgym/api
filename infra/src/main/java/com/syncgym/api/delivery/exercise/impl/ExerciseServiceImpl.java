package com.syncgym.api.delivery.exercise.impl;

import com.syncgym.api.delivery.exercise.mappers.ExerciseRepositoryMapper;
import com.syncgym.api.delivery.exercise.repositories.ExerciseRepository;
import com.syncgym.api.exercise.Exercise;
import com.syncgym.api.exercise.ports.ExerciseRepositoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Collection;

public class ExerciseServiceImpl implements ExerciseRepositoryService {

    @Autowired
    private ExerciseRepository exerciseRepository;

    @Autowired
    private ExerciseRepositoryMapper exerciseRepositoryMapper;

    @Override
    public Collection<Exercise> getAllExercisesByTargetMuscleGroup(String targetMuscleGroup) {
        return exerciseRepository.findAllByTargetMuscleGroupName(targetMuscleGroup)
                .stream().map(exerciseRepositoryMapper::mapToDomain).toList();
    }

    @Override
    public Collection<Exercise> getAllExercisesByMuscleGroup(String muscleGroup) {
        return exerciseRepository.findAllByAllMuscleGroupsName(muscleGroup)
                .stream().map(exerciseRepositoryMapper::mapToDomain).toList();
    }
}
