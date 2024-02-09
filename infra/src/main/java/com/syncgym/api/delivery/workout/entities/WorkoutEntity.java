package com.syncgym.api.delivery.workout.entities;

import com.syncgym.api.delivery.split.entities.SplitEntity;
import jakarta.persistence.*;

import java.io.Serial;
import java.io.Serializable;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "workouts")
public class WorkoutEntity implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Byte duration;

    @Column(nullable = false)
    private Byte difficulty;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "workout_id")
    private List<SplitEntity> splits;

    public WorkoutEntity(Long id, String name, Byte duration, Byte difficulty, List<SplitEntity> splits) {
        this.id = id;
        this.name = name;
        this.duration = duration;
        this.difficulty = difficulty;
        this.splits = splits;
    }

    public WorkoutEntity() {
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

    public Byte getDuration() {
        return duration;
    }

    public void setDuration(Byte duration) {
        this.duration = duration;
    }

    public Byte getDifficulty() {
        return difficulty;
    }

    public void setDifficulty(Byte difficulty) {
        this.difficulty = difficulty;
    }

    public List<SplitEntity> getSplits() {
        return splits;
    }

    public void setSplits(List<SplitEntity> splits) {
        this.splits = splits;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WorkoutEntity that = (WorkoutEntity) o;
        return Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(duration, that.duration) && Objects.equals(difficulty, that.difficulty) && Objects.equals(splits, that.splits);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, duration, difficulty, splits);
    }
}
