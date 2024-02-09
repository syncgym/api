package com.syncgym.api.delivery.split.entities;

import com.syncgym.api.delivery.exercise.entities.ExerciseEntity;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "splits")
public class SplitEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Byte ordination;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "exercise_split",
            joinColumns = {@JoinColumn(name = "split_id")},
            inverseJoinColumns = {@JoinColumn(name = "exercise_id")}
    )
    private List<ExerciseEntity> exercises;

    public SplitEntity(Long id, String name, Byte ordination, List<ExerciseEntity> exercises) {
        this.id = id;
        this.name = name;
        this.ordination = ordination;
        this.exercises = exercises;
    }

    public SplitEntity() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Byte getOrdination() {
        return ordination;
    }

    public void setOrdination(Byte ordination) {
        this.ordination = ordination;
    }

    public List<ExerciseEntity> getExercises() {
        return exercises;
    }

    public void setExercises(List<ExerciseEntity> exercises) {
        this.exercises = exercises;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SplitEntity that = (SplitEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(ordination, that.ordination) && Objects.equals(exercises, that.exercises);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, ordination, exercises);
    }
}
