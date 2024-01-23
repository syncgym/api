package com.syncgym.api.models;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "workouts")
public class Workout implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private byte duration;

    @Column(nullable = false)
    private byte difficulty;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "exercise_workout",
            joinColumns = {@JoinColumn(name = "id_workout")}, inverseJoinColumns = {@JoinColumn(name = "id_exercise")}
    )
    private List<Exercise> exercises;

    public Workout(long id, String name, byte duration, byte difficulty, List<Exercise> exercises) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.difficulty = difficulty;
        this.exercises = exercises;
    }

    public Workout() { }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public byte getDuration() {
        return duration;
    }

    public void setDuration(byte duration) {
        this.duration = duration;
    }

    public byte getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(byte difficulty) {
        this.difficulty = difficulty;
    }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) {
        this.exercises = exercises;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Workout workout = (Workout) o;
        return id == workout.id && duration == workout.duration && difficulty == workout.difficulty && Objects.equals(name, workout.name) && Objects.equals(exercises, workout.exercises);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, difficulty, exercises);
    }
}
