package com.syncgym.api.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "exercises")
public class Exercise implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "target_muscle_group_id")
    private MuscleGroup targetMuscleGroup;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private byte difficulty;

    @Column(nullable = false)
    private String description;

    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "exercise_muscle_group",
            joinColumns = {@JoinColumn(name = "id_exercise")}, inverseJoinColumns = {@JoinColumn(name = "id_muscle_group")}
    )
    private List<MuscleGroup> muscleGroups;

    public Exercise(long id, MuscleGroup targetMuscleGroup, String name, byte difficulty, String description, List<MuscleGroup> muscleGroups) {
        this.id = id;
        this.targetMuscleGroup = targetMuscleGroup;
        this.name = name;
        this.difficulty = difficulty;
        this.description = description;
        this.muscleGroups = muscleGroups;
    }

    public Exercise() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public MuscleGroup getTargetMuscleGroup() {
        return targetMuscleGroup;
    }

    public void setTargetMuscleGroup(MuscleGroup targetMuscleGroup) {
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

    public List<MuscleGroup> getMuscleGroups() {
        return muscleGroups;
    }

    public void setMuscleGroups(List<MuscleGroup> muscleGroups) {
        this.muscleGroups = muscleGroups;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Exercise exercise = (Exercise) o;
        return id == exercise.id && difficulty == exercise.difficulty && Objects.equals(targetMuscleGroup, exercise.targetMuscleGroup) && Objects.equals(name, exercise.name) && Objects.equals(description, exercise.description) && Objects.equals(muscleGroups, exercise.muscleGroups);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, targetMuscleGroup, name, difficulty, description, muscleGroups);
    }
}
