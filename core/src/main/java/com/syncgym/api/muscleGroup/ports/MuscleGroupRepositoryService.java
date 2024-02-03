package com.syncgym.api.muscleGroup.ports;

import com.syncgym.api.muscleGroup.MuscleGroup;

import java.util.Collection;
import java.util.Optional;

public interface MuscleGroupRepositoryService {

    Collection<MuscleGroup> getAllMuscleGroups();

    Optional<MuscleGroup> getMuscleGroupByName(String name);
}
