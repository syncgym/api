package com.syncgym.api.delivery.exercise.entities;

import com.syncgym.api.delivery.muscleGroup.entities.MuscleGroupEntity;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "exercises")
public class ExerciseEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "target_muscle_group_id")
    private MuscleGroupEntity targetMuscleGroup;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private byte difficulty;

    @Column(nullable = false)
    private String description;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "exercise_muscle_group",
            joinColumns = {@JoinColumn(name = "exercise_id")}, inverseJoinColumns = {@JoinColumn(name = "muscle_group_id")}
    )
    private List<MuscleGroupEntity> allMuscleGroups;

    public ExerciseEntity(Long id, MuscleGroupEntity targetMuscleGroup, String name, byte difficulty, String description, List<MuscleGroupEntity> allMuscleGroups) {
        this.id = id;
        this.targetMuscleGroup = targetMuscleGroup;
        this.name = name;
        this.difficulty = difficulty;
        this.description = description;
        this.allMuscleGroups = allMuscleGroups;
    }

    public ExerciseEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public MuscleGroupEntity getTargetMuscleGroup() {
        return targetMuscleGroup;
    }

    public void setTargetMuscleGroup(MuscleGroupEntity targetMuscleGroup) {
        this.targetMuscleGroup = targetMuscleGroup;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(byte difficulty) {
        this.difficulty = difficulty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<MuscleGroupEntity> getAllMuscleGroups() {
        return allMuscleGroups;
    }

    public void setAllMuscleGroups(List<MuscleGroupEntity> allMuscleGroups) {
        this.allMuscleGroups = allMuscleGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ExerciseEntity that = (ExerciseEntity) o;
        return difficulty == that.difficulty && Objects.equals(id, that.id) && Objects.equals(targetMuscleGroup, that.targetMuscleGroup) && Objects.equals(name, that.name) && Objects.equals(description, that.description) && Objects.equals(allMuscleGroups, that.allMuscleGroups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, targetMuscleGroup, name, difficulty, description, allMuscleGroups);
    }
}
